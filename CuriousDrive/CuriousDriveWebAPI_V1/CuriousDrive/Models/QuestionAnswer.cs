using System;
using System.Collections.Generic;

namespace CuriousDriveWebAPI.CuriousDrive.Models
{
    public partial class QuestionAnswer
    {
        public QuestionAnswer()
        {
            Comment = new HashSet<Comment>();
            PostVote = new HashSet<PostVote>();
        }

        public int QuestionAnswerId { get; set; }
        public int QuestionId { get; set; }
        public int? UserId { get; set; }
        public string AnswerHtml { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }

        public Question Question { get; set; }
        public User User { get; set; }
        public ICollection<Comment> Comment { get; set; }
        public ICollection<PostVote> PostVote { get; set; }
    }
}
