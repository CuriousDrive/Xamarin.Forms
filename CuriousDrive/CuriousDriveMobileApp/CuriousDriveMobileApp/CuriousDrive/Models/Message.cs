using System;
using System.Collections.Generic;

namespace CuriousDriveMobileApp.CuriousDrive.Models
{
    public partial class Message
    {
        public int MessageId { get; set; }
        public string DisplayMessage { get; set; }
        public string SeverityId { get; set; }
        public string SeverityValue { get; set; }
        public string InternalInstructions { get; set; }
        public string UserInstructions { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }
    }
}
