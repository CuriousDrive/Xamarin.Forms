using System;
using System.Collections.Generic;

namespace CuriousDriveWebAPI.CuriousDrive.Models
{
    public partial class Class
    {
        public Class()
        {
            QuestionClass = new HashSet<QuestionClass>();
        }

        public int ClassId { get; set; }
        public string ClassName { get; set; }
        public string Description { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }

        public ICollection<QuestionClass> QuestionClass { get; set; }
    }
}
