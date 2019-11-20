using System;
using System.Collections.Generic;

namespace BookStoresWebAPI.Models
{
    public partial class Book
    {
        public Book()
        {
            BookAuthor = new HashSet<BookAuthor>();
            Sale = new HashSet<Sale>();
        }

        public int BookId { get; set; }
        public string Title { get; set; }
        public string Type { get; set; }
        public int PubId { get; set; }
        public decimal? Price { get; set; }
        public decimal? Advance { get; set; }
        public int? Royalty { get; set; }
        public int? YtdSales { get; set; }
        public string Notes { get; set; }
        public DateTime PublishedDate { get; set; }

        public virtual Publisher Pub { get; set; }
        public virtual ICollection<BookAuthor> BookAuthor { get; set; }
        public virtual ICollection<Sale> Sale { get; set; }
    }
}
