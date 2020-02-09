using System;
using System.Collections.Generic;

namespace CuriousDriveMobileApp.CuriousDrive.Models
{
    public partial class CodeValue
    {
        public int CodeValueId { get; set; }
        public int CodeId { get; set; }
        public string CodeValue1 { get; set; }
        public string Description { get; set; }
        public string Data1 { get; set; }
        public string Data2 { get; set; }
        public string Data3 { get; set; }
        public string Comments { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }

        public Code Code { get; set; }
    }
}
