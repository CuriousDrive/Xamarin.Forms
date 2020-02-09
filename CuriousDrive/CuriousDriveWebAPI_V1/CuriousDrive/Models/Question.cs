using System;
using System.Collections.Generic;

namespace CuriousDriveWebAPI.CuriousDrive.Models
{
    public partial class Question
    {
        public Question()
        {
            Comment = new HashSet<Comment>();
            PostVote = new HashSet<PostVote>();
            QuestionAnswer = new HashSet<QuestionAnswer>();
            QuestionClass = new HashSet<QuestionClass>();
            QuestionView = new HashSet<QuestionView>();
            Tag = new HashSet<Tag>();
        }

        public int QuestionId { get; set; }
        public int? UserId { get; set; }
        public string QuestionTitle { get; set; }
        public string QuestionHtml { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }

        public User User { get; set; }
        public ICollection<Comment> Comment { get; set; }
        public ICollection<PostVote> PostVote { get; set; }
        public ICollection<QuestionAnswer> QuestionAnswer { get; set; }
        public ICollection<QuestionClass> QuestionClass { get; set; }
        public ICollection<QuestionView> QuestionView { get; set; }
        public ICollection<Tag> Tag { get; set; }
    }
}
