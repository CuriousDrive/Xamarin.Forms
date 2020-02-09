using System.Collections.Generic;

namespace CuriousDriveService.Models
{
    public class doFeedback
    {
        public object istrMode { get; set; }
        public int iintUserId { get; set; }
        public int feedbackId { get; set; }
        public int userId { get; set; }
        public string feedback { get; set; }
        public string isVerified { get; set; }
        public int value { get; set; }
        public int createdBy { get; set; }
        public string createdDate { get; set; }
        public int modifiedBy { get; set; }
        public string modifiedDate { get; set; }
        public int updateSeq { get; set; }
    }

    public class busFeedback : busBase
    {
        public doFeedback idoFeedback { get; set; }
        public string istrURLTitle { get; set; }
        public string istrDisplayName { get; set; }
        public List<busFeedback> ilstVerifiedFeedbacks { get; set; }
        public List<busFeedback> ilstFeedbacksToVerify { get; set; }
    }
}
