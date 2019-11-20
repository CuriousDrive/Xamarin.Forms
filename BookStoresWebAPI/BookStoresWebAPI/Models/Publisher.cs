using System;
using System.Collections.Generic;

namespace BookStoresWebAPI.Models
{
    public partial class Publisher
    {
        public Publisher()
        {
            Book = new HashSet<Book>();
            User = new HashSet<User>();
        }

        public int PubId { get; set; }
        public string PublisherName { get; set; }
        public string City { get; set; }
        public string State { get; set; }
        public string Country { get; set; }

        public virtual ICollection<Book> Book { get; set; }
        public virtual ICollection<User> User { get; set; }
    }
}
