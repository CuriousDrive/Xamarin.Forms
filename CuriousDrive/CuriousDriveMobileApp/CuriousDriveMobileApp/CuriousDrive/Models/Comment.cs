using System;
using System.Collections.Generic;

namespace CuriousDriveMobileApp.CuriousDrive.Models
{
    public partial class Comment
    {
        public int CommentId { get; set; }
        public string CommentHtml { get; set; }
        public int? UserId { get; set; }
        public int? QuestionId { get; set; }
        public int? AnnouncementId { get; set; }
        public int? QuestionAnswerId { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }

        public Announcement Announcement { get; set; }
        public Question Question { get; set; }
        public QuestionAnswer QuestionAnswer { get; set; }
        public User User { get; set; }
    }
}
