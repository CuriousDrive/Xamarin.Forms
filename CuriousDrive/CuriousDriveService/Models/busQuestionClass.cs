using System;
using System.Collections.Generic;

namespace CuriousDriveService.Models
{
    public class doQuestionClass
    {
        public object istrMode { get; set; }
        public int iintUserId { get; set; }
        public int questionClassId { get; set; }
        public int classId { get; set; }
        public int createdBy { get; set; }
        public object createdDate { get; set; }
        public int modifiedBy { get; set; }
        public object modifiedDate { get; set; }
        public int questionId { get; set; }
        public int updateSeq { get; set; }
    }

    public class busQuestionClass : busBase
    {        
        public doQuestionClass idoQuestionClass { get; set; }
        public String istrClassName { get; set; }
    }
}

