using System;
using System.Collections.Generic;

namespace CuriousDriveMobileApp.CuriousDrive.Models
{
    public partial class Notification
    {
        public int NotificationId { get; set; }
        public int? FromUserId { get; set; }
        public int? ToUserId { get; set; }
        public int? SubsystemId { get; set; }
        public string SubsystemValue { get; set; }
        public int? SubsystemReferenceId { get; set; }
        public int? PointId { get; set; }
        public int? MessageId { get; set; }
        public string IsRead { get; set; }
        public string IsEmail { get; set; }
        public DateTime? EmailSentDate { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }

        public User FromUser { get; set; }
        public User ToUser { get; set; }
    }
}
