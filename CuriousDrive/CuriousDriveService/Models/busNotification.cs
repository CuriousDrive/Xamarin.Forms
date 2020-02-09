using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CuriousDriveService.Models
{
    public class doNotification
    {
        public int notificationId { get; set; }
        public int fromUserId { get; set; }
        public int toUserId { get; set; }
        public int postTypeId { get; set; }
        public string postTypeValue { get; set; }
        public int subsystemId { get; set; }
        public string subsystemValue { get; set; }
        public int subsystemReferenceId { get; set; }
        public int pointId { get; set; }
        public int messageId { get; set; }
        public string isRead { get; set; }
        public string isEmail { get; set; }
        public string emailSentDate { get; set; }
        public int createdBy { get; set; }
        public string createdDate { get; set; }
        public int modifiedBy { get; set; }
        public string modifiedDate { get; set; }
        public int updateSeq { get; set; }
    }
    public class busNotification : busBase
    {
        public doNotification idoNotification { get; set; }
        public busUser ibusFromUser { get; set; }
        public int iintReferenceId { get; set; }
        public String istrNotificationHeader { get; set; }
        public String istrNotificationDetail { get; set; }
        
    }
}