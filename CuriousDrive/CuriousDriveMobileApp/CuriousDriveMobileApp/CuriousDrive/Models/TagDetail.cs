using System;
using System.Collections.Generic;

namespace CuriousDriveMobileApp.CuriousDrive.Models
{
    public partial class TagDetail
    {
        public int TagDetailId { get; set; }
        public int? TagId { get; set; }
        public int TaggedUserId { get; set; }

        public Tag Tag { get; set; }
        public User TaggedUser { get; set; }
    }
}
