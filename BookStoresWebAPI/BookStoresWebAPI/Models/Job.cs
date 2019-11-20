using System;
using System.Collections.Generic;

namespace BookStoresWebAPI.Models
{
    public partial class Job
    {
        public Job()
        {
            User = new HashSet<User>();
        }

        public short JobId { get; set; }
        public string JobDesc { get; set; }
        public byte MinLvl { get; set; }
        public byte MaxLvl { get; set; }

        public virtual ICollection<User> User { get; set; }
    }
}
