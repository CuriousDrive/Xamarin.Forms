using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace CuriousDriveWebAPI.CuriousDrive.Models
{
    public partial class CuriousDriveContext : DbContext
    {
        public CuriousDriveContext()
        {
        }

        public CuriousDriveContext(DbContextOptions<CuriousDriveContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Announcement> Announcement { get; set; }
        public virtual DbSet<Class> Class { get; set; }
        public virtual DbSet<Code> Code { get; set; }
        public virtual DbSet<CodeValue> CodeValue { get; set; }
        public virtual DbSet<Comment> Comment { get; set; }
        public virtual DbSet<Feedback> Feedback { get; set; }
        public virtual DbSet<Message> Message { get; set; }
        public virtual DbSet<Notification> Notification { get; set; }
        public virtual DbSet<Point> Point { get; set; }
        public virtual DbSet<PostVote> PostVote { get; set; }
        public virtual DbSet<Question> Question { get; set; }
        public virtual DbSet<QuestionAnswer> QuestionAnswer { get; set; }
        public virtual DbSet<QuestionClass> QuestionClass { get; set; }
        public virtual DbSet<QuestionView> QuestionView { get; set; }
        public virtual DbSet<Role> Role { get; set; }
        public virtual DbSet<Tag> Tag { get; set; }
        public virtual DbSet<TagDetail> TagDetail { get; set; }
        public virtual DbSet<User> User { get; set; }
        public virtual DbSet<UserGroup> UserGroup { get; set; }
        public virtual DbSet<UserGroupDetail> UserGroupDetail { get; set; }
        public virtual DbSet<UserRole> UserRole { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. See http://go.microsoft.com/fwlink/?LinkId=723263 for guidance on storing connection strings.
                optionsBuilder.UseSqlServer("Server=SAGITEC-0142\\SQLEXPRESS;Database=CuriousDrive;Trusted_Connection=True;");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Announcement>(entity =>
            {
                entity.ToTable("ANNOUNCEMENT");

                entity.Property(e => e.AnnouncementId).HasColumnName("ANNOUNCEMENT_ID");

                entity.Property(e => e.AnnouncementHtml).HasColumnName("ANNOUNCEMENT_HTML");

                entity.Property(e => e.AnnouncementTitle)
                    .IsRequired()
                    .HasColumnName("ANNOUNCEMENT_TITLE")
                    .HasMaxLength(500);

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.UserId).HasColumnName("USER_ID");

                entity.HasOne(d => d.User)
                    .WithMany(p => p.Announcement)
                    .HasForeignKey(d => d.UserId)
                    .HasConstraintName("announcement$FK_AnnouncementUser");
            });

            modelBuilder.Entity<Class>(entity =>
            {
                entity.ToTable("CLASS");

                entity.HasIndex(e => e.ClassName)
                    .HasName("class$CATEGORY")
                    .IsUnique();

                entity.Property(e => e.ClassId).HasColumnName("CLASS_ID");

                entity.Property(e => e.ClassName)
                    .HasColumnName("CLASS_NAME")
                    .HasMaxLength(100)
                    .IsUnicode(false);

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Description)
                    .HasColumnName("DESCRIPTION")
                    .IsUnicode(false);

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");
            });

            modelBuilder.Entity<Code>(entity =>
            {
                entity.ToTable("CODE");

                entity.Property(e => e.CodeId).HasColumnName("CODE_ID");

                entity.Property(e => e.CodeDescription)
                    .IsRequired()
                    .HasColumnName("CODE_DESCRIPTION")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.Comments)
                    .HasColumnName("COMMENTS")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Data1Caption)
                    .HasColumnName("DATA1_CAPTION")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.Data1Type)
                    .HasColumnName("DATA1_TYPE")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.Data2Caption)
                    .HasColumnName("DATA2_CAPTION")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.Data2Type)
                    .HasColumnName("DATA2_TYPE")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.Data3Caption)
                    .HasColumnName("DATA3_CAPTION")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.Data3Type)
                    .HasColumnName("DATA3_TYPE")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");
            });

            modelBuilder.Entity<CodeValue>(entity =>
            {
                entity.ToTable("CODE_VALUE");

                entity.HasIndex(e => e.CodeId)
                    .HasName("FK_CodeCodeValue");

                entity.Property(e => e.CodeValueId).HasColumnName("CODE_VALUE_ID");

                entity.Property(e => e.CodeId).HasColumnName("CODE_ID");

                entity.Property(e => e.CodeValue1)
                    .IsRequired()
                    .HasColumnName("CODE_VALUE")
                    .HasMaxLength(500)
                    .IsUnicode(false);

                entity.Property(e => e.Comments)
                    .HasColumnName("COMMENTS")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Data1)
                    .HasColumnName("DATA1")
                    .HasMaxLength(500)
                    .IsUnicode(false);

                entity.Property(e => e.Data2)
                    .HasColumnName("DATA2")
                    .HasMaxLength(500)
                    .IsUnicode(false);

                entity.Property(e => e.Data3)
                    .HasColumnName("DATA3")
                    .HasMaxLength(500)
                    .IsUnicode(false);

                entity.Property(e => e.Description)
                    .HasColumnName("DESCRIPTION")
                    .HasMaxLength(500)
                    .IsUnicode(false);

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");

                entity.HasOne(d => d.Code)
                    .WithMany(p => p.CodeValue)
                    .HasForeignKey(d => d.CodeId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("code_value$FK_CodeCodeValue");
            });

            modelBuilder.Entity<Comment>(entity =>
            {
                entity.ToTable("COMMENT");

                entity.Property(e => e.CommentId).HasColumnName("COMMENT_ID");

                entity.Property(e => e.AnnouncementId).HasColumnName("ANNOUNCEMENT_ID");

                entity.Property(e => e.CommentHtml)
                    .IsRequired()
                    .HasColumnName("COMMENT_HTML")
                    .HasMaxLength(2000);

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.QuestionAnswerId).HasColumnName("QUESTION_ANSWER_ID");

                entity.Property(e => e.QuestionId).HasColumnName("QUESTION_ID");

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.UserId).HasColumnName("USER_ID");

                entity.HasOne(d => d.Announcement)
                    .WithMany(p => p.Comment)
                    .HasForeignKey(d => d.AnnouncementId)
                    .HasConstraintName("comment$FK_AnnouncementComment");

                entity.HasOne(d => d.QuestionAnswer)
                    .WithMany(p => p.Comment)
                    .HasForeignKey(d => d.QuestionAnswerId)
                    .HasConstraintName("comment$FK_QuestionAnswerComment");

                entity.HasOne(d => d.Question)
                    .WithMany(p => p.Comment)
                    .HasForeignKey(d => d.QuestionId)
                    .HasConstraintName("comment$FK_QuestionComment");

                entity.HasOne(d => d.User)
                    .WithMany(p => p.Comment)
                    .HasForeignKey(d => d.UserId)
                    .HasConstraintName("comment$FK_UserComment");
            });

            modelBuilder.Entity<Feedback>(entity =>
            {
                entity.ToTable("FEEDBACK");

                entity.HasIndex(e => e.UserId)
                    .HasName("FK_UserFeedback");

                entity.Property(e => e.FeedbackId).HasColumnName("FEEDBACK_ID");

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.FeedbackText)
                    .IsRequired()
                    .HasColumnName("FEEDBACK_TEXT")
                    .HasMaxLength(500)
                    .IsUnicode(false);

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.UserId).HasColumnName("USER_ID");

                entity.HasOne(d => d.User)
                    .WithMany(p => p.Feedback)
                    .HasForeignKey(d => d.UserId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("feedback$FK_UserFeedback");
            });

            modelBuilder.Entity<Message>(entity =>
            {
                entity.ToTable("MESSAGE");

                entity.Property(e => e.MessageId)
                    .HasColumnName("MESSAGE_ID")
                    .ValueGeneratedNever();

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.DisplayMessage)
                    .IsRequired()
                    .HasColumnName("DISPLAY_MESSAGE")
                    .HasMaxLength(200)
                    .IsUnicode(false);

                entity.Property(e => e.InternalInstructions)
                    .HasColumnName("INTERNAL_INSTRUCTIONS")
                    .HasMaxLength(200)
                    .IsUnicode(false);

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.SeverityId)
                    .HasColumnName("SEVERITY_ID")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.SeverityValue)
                    .HasColumnName("SEVERITY_VALUE")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.UserInstructions)
                    .HasColumnName("USER_INSTRUCTIONS")
                    .HasMaxLength(200)
                    .IsUnicode(false);
            });

            modelBuilder.Entity<Notification>(entity =>
            {
                entity.ToTable("NOTIFICATION");

                entity.HasIndex(e => e.FromUserId)
                    .HasName("FK_FromUserUser");

                entity.HasIndex(e => e.ToUserId)
                    .HasName("FK_ToUserUser");

                entity.Property(e => e.NotificationId).HasColumnName("NOTIFICATION_ID");

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.EmailSentDate)
                    .HasColumnName("EMAIL_SENT_DATE")
                    .HasColumnType("datetime2(0)");

                entity.Property(e => e.FromUserId).HasColumnName("FROM_USER_ID");

                entity.Property(e => e.IsEmail)
                    .HasColumnName("IS_EMAIL")
                    .HasMaxLength(5)
                    .IsUnicode(false);

                entity.Property(e => e.IsRead)
                    .HasColumnName("IS_READ")
                    .HasMaxLength(5)
                    .IsUnicode(false);

                entity.Property(e => e.MessageId).HasColumnName("MESSAGE_ID");

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.PointId).HasColumnName("POINT_ID");

                entity.Property(e => e.SubsystemId).HasColumnName("SUBSYSTEM_ID");

                entity.Property(e => e.SubsystemReferenceId).HasColumnName("SUBSYSTEM_REFERENCE_ID");

                entity.Property(e => e.SubsystemValue)
                    .HasColumnName("SUBSYSTEM_VALUE")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.ToUserId).HasColumnName("TO_USER_ID");

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");

                entity.HasOne(d => d.FromUser)
                    .WithMany(p => p.NotificationFromUser)
                    .HasForeignKey(d => d.FromUserId)
                    .HasConstraintName("notification$FK_FromUserUser");

                entity.HasOne(d => d.ToUser)
                    .WithMany(p => p.NotificationToUser)
                    .HasForeignKey(d => d.ToUserId)
                    .HasConstraintName("notification$FK_ToUserUser");
            });

            modelBuilder.Entity<Point>(entity =>
            {
                entity.ToTable("POINT");

                entity.HasIndex(e => e.UserId)
                    .HasName("FK_PointUser");

                entity.Property(e => e.PointId).HasColumnName("POINT_ID");

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Points).HasColumnName("POINTS");

                entity.Property(e => e.PointsTypeId).HasColumnName("POINTS_TYPE_ID");

                entity.Property(e => e.PointsTypeValue)
                    .HasColumnName("POINTS_TYPE_VALUE")
                    .HasMaxLength(10)
                    .IsUnicode(false);

                entity.Property(e => e.QuestionAnswerId).HasColumnName("QUESTION_ANSWER_ID");

                entity.Property(e => e.QuestionId).HasColumnName("QUESTION_ID");

                entity.Property(e => e.SubsystemId).HasColumnName("SUBSYSTEM_ID");

                entity.Property(e => e.SubsystemReferenceId).HasColumnName("SUBSYSTEM_REFERENCE_ID");

                entity.Property(e => e.SubsystemValue)
                    .HasColumnName("SUBSYSTEM_VALUE")
                    .HasMaxLength(10)
                    .IsUnicode(false);

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.UserId).HasColumnName("USER_ID");

                entity.HasOne(d => d.User)
                    .WithMany(p => p.Point)
                    .HasForeignKey(d => d.UserId)
                    .HasConstraintName("point$FK_PointUser");
            });

            modelBuilder.Entity<PostVote>(entity =>
            {
                entity.ToTable("POST_VOTE");

                entity.Property(e => e.PostVoteId).HasColumnName("POST_VOTE_ID");

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.QuestionAnswerId).HasColumnName("QUESTION_ANSWER_ID");

                entity.Property(e => e.QuestionId).HasColumnName("QUESTION_ID");

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.UserId).HasColumnName("USER_ID");

                entity.Property(e => e.VoteValue)
                    .HasColumnName("VOTE_VALUE")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.HasOne(d => d.QuestionAnswer)
                    .WithMany(p => p.PostVote)
                    .HasForeignKey(d => d.QuestionAnswerId)
                    .HasConstraintName("post_vote$FK_PostVoteQuestionAnswer");

                entity.HasOne(d => d.Question)
                    .WithMany(p => p.PostVote)
                    .HasForeignKey(d => d.QuestionId)
                    .HasConstraintName("post_vote$FK_PostVoteQuestion");

                entity.HasOne(d => d.User)
                    .WithMany(p => p.PostVote)
                    .HasForeignKey(d => d.UserId)
                    .HasConstraintName("post_vote$FK_PostVoteUser");
            });

            modelBuilder.Entity<Question>(entity =>
            {
                entity.ToTable("QUESTION");

                entity.HasIndex(e => e.UserId)
                    .HasName("FK_QuestionUser");

                entity.Property(e => e.QuestionId).HasColumnName("QUESTION_ID");

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.QuestionHtml).HasColumnName("QUESTION_HTML");

                entity.Property(e => e.QuestionTitle)
                    .IsRequired()
                    .HasColumnName("QUESTION_TITLE")
                    .HasMaxLength(500);

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.UserId).HasColumnName("USER_ID");

                entity.HasOne(d => d.User)
                    .WithMany(p => p.Question)
                    .HasForeignKey(d => d.UserId)
                    .HasConstraintName("question$FK_QuestionUser");
            });

            modelBuilder.Entity<QuestionAnswer>(entity =>
            {
                entity.ToTable("QUESTION_ANSWER");

                entity.HasIndex(e => e.QuestionId)
                    .HasName("FK_QuestionClassQuestion");

                entity.HasIndex(e => e.UserId)
                    .HasName("FK_QuestionAnswerUser");

                entity.Property(e => e.QuestionAnswerId).HasColumnName("QUESTION_ANSWER_ID");

                entity.Property(e => e.AnswerHtml).HasColumnName("ANSWER_HTML");

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.QuestionId).HasColumnName("QUESTION_ID");

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.UserId).HasColumnName("USER_ID");

                entity.HasOne(d => d.Question)
                    .WithMany(p => p.QuestionAnswer)
                    .HasForeignKey(d => d.QuestionId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("question_answer$FK_QuestionAnswerQuestion");

                entity.HasOne(d => d.User)
                    .WithMany(p => p.QuestionAnswer)
                    .HasForeignKey(d => d.UserId)
                    .HasConstraintName("question_answer$FK_QuestionAnswerUser");
            });

            modelBuilder.Entity<QuestionClass>(entity =>
            {
                entity.ToTable("QUESTION_CLASS");

                entity.Property(e => e.QuestionClassId).HasColumnName("QUESTION_CLASS_ID");

                entity.Property(e => e.ClassId).HasColumnName("CLASS_ID");

                entity.Property(e => e.QuestionId).HasColumnName("QUESTION_ID");

                entity.HasOne(d => d.Class)
                    .WithMany(p => p.QuestionClass)
                    .HasForeignKey(d => d.ClassId)
                    .HasConstraintName("question_class$FK_QuestionClassClass");

                entity.HasOne(d => d.Question)
                    .WithMany(p => p.QuestionClass)
                    .HasForeignKey(d => d.QuestionId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("question_class$FK_QuestionClassQuestion");
            });

            modelBuilder.Entity<QuestionView>(entity =>
            {
                entity.ToTable("QUESTION_VIEW");

                entity.HasIndex(e => e.QuestionId)
                    .HasName("FK_QuestionViewQuestion");

                entity.HasIndex(e => e.UserId)
                    .HasName("FK_QuestionViewUser");

                entity.Property(e => e.QuestionViewId).HasColumnName("QUESTION_VIEW_ID");

                entity.Property(e => e.Browser)
                    .HasColumnName("BROWSER")
                    .HasMaxLength(500)
                    .IsUnicode(false);

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.IpAddress)
                    .HasColumnName("IP_ADDRESS")
                    .HasMaxLength(500)
                    .IsUnicode(false);

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.QuestionId).HasColumnName("QUESTION_ID");

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.UserId).HasColumnName("USER_ID");

                entity.HasOne(d => d.Question)
                    .WithMany(p => p.QuestionView)
                    .HasForeignKey(d => d.QuestionId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("question_view$FK_QuestionViewQuestion");

                entity.HasOne(d => d.User)
                    .WithMany(p => p.QuestionView)
                    .HasForeignKey(d => d.UserId)
                    .HasConstraintName("question_view$FK_QuestionViewUser");
            });

            modelBuilder.Entity<Role>(entity =>
            {
                entity.ToTable("ROLE");

                entity.Property(e => e.RoleId).HasColumnName("ROLE_ID");

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.RoleDescription)
                    .IsRequired()
                    .HasColumnName("ROLE_DESCRIPTION")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.RoleName)
                    .IsRequired()
                    .HasColumnName("ROLE_NAME")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");
            });

            modelBuilder.Entity<Tag>(entity =>
            {
                entity.ToTable("TAG");

                entity.HasIndex(e => e.AnnouncementId)
                    .HasName("FK_TagAnnouncement");

                entity.HasIndex(e => e.QuestionId)
                    .HasName("FK_TagQuestion");

                entity.Property(e => e.TagId).HasColumnName("TAG_ID");

                entity.Property(e => e.AnnouncementId).HasColumnName("ANNOUNCEMENT_ID");

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.QuestionId).HasColumnName("QUESTION_ID");

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.UserGroupId).HasColumnName("USER_GROUP_ID");

                entity.Property(e => e.UserGroupTypeId).HasColumnName("USER_GROUP_TYPE_ID");

                entity.Property(e => e.UserGroupTypeValue)
                    .HasColumnName("USER_GROUP_TYPE_VALUE")
                    .HasMaxLength(50);

                entity.HasOne(d => d.Announcement)
                    .WithMany(p => p.Tag)
                    .HasForeignKey(d => d.AnnouncementId)
                    .HasConstraintName("tag$FK_TagAnnouncement");

                entity.HasOne(d => d.Question)
                    .WithMany(p => p.Tag)
                    .HasForeignKey(d => d.QuestionId)
                    .HasConstraintName("tag$FK_TagQuestion");
            });

            modelBuilder.Entity<TagDetail>(entity =>
            {
                entity.ToTable("TAG_DETAIL");

                entity.HasIndex(e => e.TagId)
                    .HasName("FK_TagDetailTag");

                entity.HasIndex(e => e.TaggedUserId)
                    .HasName("FK_TagDetailUser");

                entity.Property(e => e.TagDetailId).HasColumnName("TAG_DETAIL_ID");

                entity.Property(e => e.TagId).HasColumnName("TAG_ID");

                entity.Property(e => e.TaggedUserId).HasColumnName("TAGGED_USER_ID");

                entity.HasOne(d => d.Tag)
                    .WithMany(p => p.TagDetail)
                    .HasForeignKey(d => d.TagId)
                    .HasConstraintName("tag_detail$FK_TagDetailTag");

                entity.HasOne(d => d.TaggedUser)
                    .WithMany(p => p.TagDetail)
                    .HasForeignKey(d => d.TaggedUserId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("tag_detail$FK_TagDetailUser");
            });

            modelBuilder.Entity<User>(entity =>
            {
                entity.ToTable("USER");

                entity.HasIndex(e => new { e.EmailAddress, e.NetworkValue })
                    .HasName("compositeUniqueKeyEmailAddressNetworkValue")
                    .IsUnique();

                entity.Property(e => e.UserId).HasColumnName("USER_ID");

                entity.Property(e => e.AboutMe)
                    .HasColumnName("ABOUT_ME")
                    .IsUnicode(false);

                entity.Property(e => e.BirthDate)
                    .HasColumnName("BIRTH_DATE")
                    .HasColumnType("datetime2(0)");

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.DisplayName)
                    .HasColumnName("DISPLAY_NAME")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.EmailAddress)
                    .IsRequired()
                    .HasColumnName("EMAIL_ADDRESS")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.FacebookUrl)
                    .HasColumnName("FACEBOOK_URL")
                    .HasMaxLength(2048)
                    .IsUnicode(false);

                entity.Property(e => e.FirstName)
                    .HasColumnName("FIRST_NAME")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.GenderId).HasColumnName("GENDER_ID");

                entity.Property(e => e.GenderValue)
                    .HasColumnName("GENDER_VALUE")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.InstagramUrl)
                    .HasColumnName("INSTAGRAM_URL")
                    .HasMaxLength(2048)
                    .IsUnicode(false);

                entity.Property(e => e.Interests)
                    .HasColumnName("INTERESTS")
                    .HasMaxLength(2048)
                    .IsUnicode(false);

                entity.Property(e => e.IsPasswordForgotten)
                    .HasColumnName("IS_PASSWORD_FORGOTTEN")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.IsUserVerified)
                    .HasColumnName("IS_USER_VERIFIED")
                    .HasMaxLength(5)
                    .IsUnicode(false);

                entity.Property(e => e.LastName)
                    .HasColumnName("LAST_NAME")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.NetworkId).HasColumnName("NETWORK_ID");

                entity.Property(e => e.NetworkValue)
                    .HasColumnName("NETWORK_VALUE")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.Occupation)
                    .HasColumnName("OCCUPATION")
                    .HasMaxLength(2048)
                    .IsUnicode(false);

                entity.Property(e => e.Otp)
                    .HasColumnName("OTP")
                    .HasMaxLength(500)
                    .IsUnicode(false);

                entity.Property(e => e.Password)
                    .HasColumnName("PASSWORD")
                    .HasMaxLength(500)
                    .IsUnicode(false);

                entity.Property(e => e.PhoneNumber)
                    .HasColumnName("PHONE_NUMBER")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.PictureUrl)
                    .HasColumnName("PICTURE_URL")
                    .HasMaxLength(2048)
                    .IsUnicode(false);

                entity.Property(e => e.SaltValue)
                    .HasColumnName("SALT_VALUE")
                    .HasMaxLength(500)
                    .IsUnicode(false);

                entity.Property(e => e.TwitterUrl)
                    .HasColumnName("TWITTER_URL")
                    .HasMaxLength(2048)
                    .IsUnicode(false);

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.UserStatusId).HasColumnName("USER_STATUS_ID");

                entity.Property(e => e.UserStatusValue)
                    .HasColumnName("USER_STATUS_VALUE")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.WebsiteUrl)
                    .HasColumnName("WEBSITE_URL")
                    .HasMaxLength(2048)
                    .IsUnicode(false);
            });

            modelBuilder.Entity<UserGroup>(entity =>
            {
                entity.ToTable("USER_GROUP");

                entity.Property(e => e.UserGroupId).HasColumnName("USER_GROUP_ID");

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.GroupDescription)
                    .HasColumnName("GROUP_DESCRIPTION")
                    .HasMaxLength(500);

                entity.Property(e => e.GroupName)
                    .HasColumnName("GROUP_NAME")
                    .HasMaxLength(50);

                entity.Property(e => e.GroupStatusId).HasColumnName("GROUP_STATUS_ID");

                entity.Property(e => e.GroupStatusValue)
                    .HasColumnName("GROUP_STATUS_VALUE")
                    .HasMaxLength(50);

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");
            });

            modelBuilder.Entity<UserGroupDetail>(entity =>
            {
                entity.ToTable("USER_GROUP_DETAIL");

                entity.HasIndex(e => e.UserGroupId)
                    .HasName("FK_UserGroupDetailUserGroup");

                entity.HasIndex(e => e.UserId)
                    .HasName("FK_UserGroupDetailUser");

                entity.Property(e => e.UserGroupDetailId).HasColumnName("USER_GROUP_DETAIL_ID");

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.UserGroupId).HasColumnName("USER_GROUP_ID");

                entity.Property(e => e.UserId).HasColumnName("USER_ID");

                entity.HasOne(d => d.UserGroup)
                    .WithMany(p => p.UserGroupDetail)
                    .HasForeignKey(d => d.UserGroupId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("user_group_detail$FK_UserGroupDetailUserGroup");

                entity.HasOne(d => d.User)
                    .WithMany(p => p.UserGroupDetail)
                    .HasForeignKey(d => d.UserId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("user_group_detail$FK_UserGroupDetailUser");
            });

            modelBuilder.Entity<UserRole>(entity =>
            {
                entity.ToTable("USER_ROLE");

                entity.HasIndex(e => e.UserId)
                    .HasName("FK_UserRoleUser");

                entity.Property(e => e.UserRoleId).HasColumnName("USER_ROLE_ID");

                entity.Property(e => e.CreatedBy).HasColumnName("CREATED_BY");

                entity.Property(e => e.CreatedDate)
                    .HasColumnName("CREATED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.ModifiedBy).HasColumnName("MODIFIED_BY");

                entity.Property(e => e.ModifiedDate)
                    .HasColumnName("MODIFIED_DATE")
                    .HasColumnType("datetime2(0)")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.RoleId).HasColumnName("ROLE_ID");

                entity.Property(e => e.UpdateSeq)
                    .HasColumnName("UPDATE_SEQ")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.UserId).HasColumnName("USER_ID");

                entity.HasOne(d => d.Role)
                    .WithMany(p => p.UserRole)
                    .HasForeignKey(d => d.RoleId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("user_role$FK_UserRoleRole");

                entity.HasOne(d => d.User)
                    .WithMany(p => p.UserRole)
                    .HasForeignKey(d => d.UserId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("user_role$FK_UserRoleUser");
            });
        }
    }
}
