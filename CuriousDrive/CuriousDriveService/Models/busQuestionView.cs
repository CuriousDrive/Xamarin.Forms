using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CuriousDriveService.Models
{
    public class doQuestionView
    {
        public object istrMode { get; set; }
        public int iintUserId { get; set; }
        public int questionViewId { get; set; }
        public int createdBy { get; set; }
        public object createdDate { get; set; }
        public int modifiedBy { get; set; }
        public object modifiedDate { get; set; }
        public int questionId { get; set; }
        public int updateSeq { get; set; }
        public int userId { get; set; }
        public string browser { get; set; }
        public string ipAddress { get; set; }
    }

    public class busQuesitonView : busBase
    {
        public doQuestionView idoQuestionView { get; set; }
    }
}