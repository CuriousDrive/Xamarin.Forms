using System;
using System.Collections.Generic;

namespace CuriousDriveWebAPI.CuriousDrive.Models
{
    public partial class Code
    {
        public Code()
        {
            CodeValue = new HashSet<CodeValue>();
        }

        public int CodeId { get; set; }
        public string CodeDescription { get; set; }
        public string Data1Caption { get; set; }
        public string Data1Type { get; set; }
        public string Data2Caption { get; set; }
        public string Data2Type { get; set; }
        public string Data3Caption { get; set; }
        public string Data3Type { get; set; }
        public string Comments { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }

        public ICollection<CodeValue> CodeValue { get; set; }
    }
}
