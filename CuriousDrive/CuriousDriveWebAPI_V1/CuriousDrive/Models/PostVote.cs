using System;
using System.Collections.Generic;

namespace CuriousDriveWebAPI.CuriousDrive.Models
{
    public partial class PostVote
    {
        public int PostVoteId { get; set; }
        public int? QuestionId { get; set; }
        public int? QuestionAnswerId { get; set; }
        public string VoteValue { get; set; }
        public int? UserId { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }

        public Question Question { get; set; }
        public QuestionAnswer QuestionAnswer { get; set; }
        public User User { get; set; }
    }
}
