using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace BookStoresWebAPI.Models
{
    public partial class BookStoresDBContext : DbContext
    {
        public BookStoresDBContext()
        {
        }

        public BookStoresDBContext(DbContextOptions<BookStoresDBContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Author> Author { get; set; }
        public virtual DbSet<Book> Book { get; set; }
        public virtual DbSet<BookAuthor> BookAuthor { get; set; }
        public virtual DbSet<Job> Job { get; set; }
        public virtual DbSet<Publisher> Publisher { get; set; }
        public virtual DbSet<Sale> Sale { get; set; }
        public virtual DbSet<Store> Store { get; set; }
        public virtual DbSet<User> User { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                //#warning To protect potentially sensitive information in your connection string, you should move it out of source code. See http://go.microsoft.com/fwlink/?LinkId=723263 for guidance on storing connection strings.
                optionsBuilder.UseSqlServer("Server=.\\SQLExpress;Database=BookStoresDB;Trusted_Connection=True;");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Author>(entity =>
            {
                entity.Property(e => e.AuthorId).HasColumnName("author_id");

                entity.Property(e => e.Address)
                    .HasColumnName("address")
                    .HasMaxLength(40)
                    .IsUnicode(false);

                entity.Property(e => e.City)
                    .HasColumnName("city")
                    .HasMaxLength(20)
                    .IsUnicode(false);

                entity.Property(e => e.FirstName)
                    .IsRequired()
                    .HasColumnName("first_name")
                    .HasMaxLength(20)
                    .IsUnicode(false);

                entity.Property(e => e.LastName)
                    .IsRequired()
                    .HasColumnName("last_name")
                    .HasMaxLength(40)
                    .IsUnicode(false);

                entity.Property(e => e.Phone)
                    .IsRequired()
                    .HasColumnName("phone")
                    .HasMaxLength(12)
                    .IsUnicode(false)
                    .IsFixedLength()
                    .HasDefaultValueSql("('UNKNOWN')");

                entity.Property(e => e.State)
                    .HasColumnName("state")
                    .HasMaxLength(2)
                    .IsUnicode(false)
                    .IsFixedLength();

                entity.Property(e => e.Zip)
                    .HasColumnName("zip")
                    .HasMaxLength(5)
                    .IsUnicode(false)
                    .IsFixedLength();
            });

            modelBuilder.Entity<Book>(entity =>
            {
                entity.Property(e => e.BookId).HasColumnName("book_id");

                entity.Property(e => e.Advance)
                    .HasColumnName("advance")
                    .HasColumnType("money");

                entity.Property(e => e.Notes)
                    .HasColumnName("notes")
                    .HasMaxLength(200)
                    .IsUnicode(false);

                entity.Property(e => e.Price)
                    .HasColumnName("price")
                    .HasColumnType("money");

                entity.Property(e => e.PubId).HasColumnName("pub_id");

                entity.Property(e => e.PublishedDate)
                    .HasColumnName("published_date")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Royalty).HasColumnName("royalty");

                entity.Property(e => e.Title)
                    .IsRequired()
                    .HasColumnName("title")
                    .HasMaxLength(80)
                    .IsUnicode(false);

                entity.Property(e => e.Type)
                    .IsRequired()
                    .HasColumnName("type")
                    .HasMaxLength(12)
                    .IsUnicode(false)
                    .IsFixedLength()
                    .HasDefaultValueSql("('UNDECIDED')");

                entity.Property(e => e.YtdSales).HasColumnName("ytd_sales");

                entity.HasOne(d => d.Pub)
                    .WithMany(p => p.Book)
                    .HasForeignKey(d => d.PubId)
                    .HasConstraintName("FK__Book__pub_id__6166761E");
            });

            modelBuilder.Entity<BookAuthor>(entity =>
            {
                entity.HasKey(e => new { e.AuthorId, e.BookId });

                entity.Property(e => e.AuthorId).HasColumnName("author_id");

                entity.Property(e => e.BookId).HasColumnName("book_id");

                entity.Property(e => e.AuthorOrder).HasColumnName("author_order");

                entity.Property(e => e.RoyalityPercentage).HasColumnName("royality_percentage");

                entity.HasOne(d => d.Author)
                    .WithMany(p => p.BookAuthor)
                    .HasForeignKey(d => d.AuthorId)
                    .HasConstraintName("FK__BookAutho__autho__43D61337");

                entity.HasOne(d => d.Book)
                    .WithMany(p => p.BookAuthor)
                    .HasForeignKey(d => d.BookId)
                    .HasConstraintName("FK__BookAutho__book___42E1EEFE");
            });

            modelBuilder.Entity<Job>(entity =>
            {
                entity.Property(e => e.JobId).HasColumnName("job_id");

                entity.Property(e => e.JobDesc)
                    .IsRequired()
                    .HasColumnName("job_desc")
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasDefaultValueSql("('New Position - title not formalized yet')");

                entity.Property(e => e.MaxLvl).HasColumnName("max_lvl");

                entity.Property(e => e.MinLvl).HasColumnName("min_lvl");
            });

            modelBuilder.Entity<Publisher>(entity =>
            {
                entity.HasKey(e => e.PubId)
                    .HasName("PK__Publishe__2515F222DDC013AD");

                entity.Property(e => e.PubId).HasColumnName("pub_id");

                entity.Property(e => e.City)
                    .HasColumnName("city")
                    .HasMaxLength(20)
                    .IsUnicode(false);

                entity.Property(e => e.Country)
                    .HasColumnName("country")
                    .HasMaxLength(30)
                    .IsUnicode(false)
                    .HasDefaultValueSql("('USA')");

                entity.Property(e => e.PublisherName)
                    .HasColumnName("publisher_name")
                    .HasMaxLength(40)
                    .IsUnicode(false);

                entity.Property(e => e.State)
                    .HasColumnName("state")
                    .HasMaxLength(2)
                    .IsUnicode(false)
                    .IsFixedLength();
            });

            modelBuilder.Entity<Sale>(entity =>
            {
                entity.Property(e => e.SaleId).HasColumnName("sale_id");

                entity.Property(e => e.BookId).HasColumnName("book_id");

                entity.Property(e => e.OrderDate)
                    .HasColumnName("order_date")
                    .HasColumnType("datetime");

                entity.Property(e => e.OrderNum)
                    .IsRequired()
                    .HasColumnName("order_num")
                    .HasMaxLength(20)
                    .IsUnicode(false);

                entity.Property(e => e.PayTerms)
                    .IsRequired()
                    .HasColumnName("pay_terms")
                    .HasMaxLength(12)
                    .IsUnicode(false);

                entity.Property(e => e.Quantity).HasColumnName("quantity");

                entity.Property(e => e.StoreId)
                    .IsRequired()
                    .HasColumnName("store_id")
                    .HasMaxLength(4)
                    .IsUnicode(false)
                    .IsFixedLength();

                entity.HasOne(d => d.Book)
                    .WithMany(p => p.Sale)
                    .HasForeignKey(d => d.BookId)
                    .HasConstraintName("FK__Sale2__book_id__756D6ECB");

                entity.HasOne(d => d.Store)
                    .WithMany(p => p.Sale)
                    .HasForeignKey(d => d.StoreId)
                    .HasConstraintName("FK__Sale2__store_id__76619304");
            });

            modelBuilder.Entity<Store>(entity =>
            {
                entity.Property(e => e.StoreId)
                    .HasColumnName("store_id")
                    .HasMaxLength(4)
                    .IsUnicode(false)
                    .IsFixedLength();

                entity.Property(e => e.City)
                    .HasColumnName("city")
                    .HasMaxLength(20)
                    .IsUnicode(false);

                entity.Property(e => e.State)
                    .HasColumnName("state")
                    .HasMaxLength(2)
                    .IsUnicode(false)
                    .IsFixedLength();

                entity.Property(e => e.StoreAddress)
                    .HasColumnName("store_address")
                    .HasMaxLength(40)
                    .IsUnicode(false);

                entity.Property(e => e.StoreName)
                    .HasColumnName("store_name")
                    .HasMaxLength(40)
                    .IsUnicode(false);

                entity.Property(e => e.Zip)
                    .HasColumnName("zip")
                    .HasMaxLength(5)
                    .IsUnicode(false)
                    .IsFixedLength();
            });

            modelBuilder.Entity<User>(entity =>
            {
                entity.HasKey(e => e.UserId)
                    .HasName("PK_user_id")
                    .IsClustered(false);

                entity.Property(e => e.UserId)
                    .HasColumnName("user_id")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.FirstName)
                    .IsRequired()
                    .HasColumnName("first_name")
                    .HasMaxLength(20)
                    .IsUnicode(false);

                entity.Property(e => e.HireDate)
                    .HasColumnName("hire_date")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.JobId)
                    .HasColumnName("job_id")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.JobLevel)
                    .HasColumnName("job_level")
                    .HasDefaultValueSql("((10))");

                entity.Property(e => e.LastName)
                    .IsRequired()
                    .HasColumnName("last_name")
                    .HasMaxLength(30)
                    .IsUnicode(false);

                entity.Property(e => e.MiddleName)
                    .HasColumnName("middle_name")
                    .HasMaxLength(1)
                    .IsUnicode(false)
                    .IsFixedLength();

                entity.Property(e => e.Password)
                    .HasColumnName("password")
                    .HasMaxLength(100)
                    .IsUnicode(false);

                entity.Property(e => e.PubId).HasColumnName("pub_id");

                entity.HasOne(d => d.Job)
                    .WithMany(p => p.User)
                    .HasForeignKey(d => d.JobId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK__Users__job_id__114A936A");

                entity.HasOne(d => d.Pub)
                    .WithMany(p => p.User)
                    .HasForeignKey(d => d.PubId)
                    .HasConstraintName("FK__Users__pub_id__607251E5");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
