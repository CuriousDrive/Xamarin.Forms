using System;
using System.Collections.Generic;

namespace CuriousDriveWebAPI.CuriousDrive.Models
{
    public partial class QuestionView
    {
        public int QuestionViewId { get; set; }
        public int QuestionId { get; set; }
        public int? UserId { get; set; }
        public string Browser { get; set; }
        public string IpAddress { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }

        public Question Question { get; set; }
        public User User { get; set; }
    }
}
