using System;
using System.Collections.Generic;

namespace CuriousDriveWebAPI.CuriousDrive.Models
{
    public partial class QuestionClass
    {
        public int QuestionClassId { get; set; }
        public int QuestionId { get; set; }
        public int? ClassId { get; set; }

        public Class Class { get; set; }
        public Question Question { get; set; }
    }
}
