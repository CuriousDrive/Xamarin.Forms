using System;
using System.Collections.Generic;

namespace CuriousDriveWebAPI.CuriousDrive.Models
{
    public partial class Announcement
    {
        public Announcement()
        {
            Comment = new HashSet<Comment>();
            Tag = new HashSet<Tag>();
        }

        public int AnnouncementId { get; set; }
        public int? UserId { get; set; }
        public string AnnouncementTitle { get; set; }
        public string AnnouncementHtml { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }

        public User User { get; set; }
        public ICollection<Comment> Comment { get; set; }
        public ICollection<Tag> Tag { get; set; }
    }
}
