using System;
using System.Collections.Generic;

namespace CuriousDriveMobileApp.CuriousDrive.Models
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
