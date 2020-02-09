using System;
using System.Collections.Generic;

namespace CuriousDriveService.Models
{
	public class doQuestionAnswer
	{
		public object istrMode { get; set; }
		public int iintUserId { get; set; }
		public int questionAnswerId { get; set; }
		public string answerHtml { get; set; }
		public int createdBy { get; set; }
		public string createdDate { get; set; }
		public int modifiedBy { get; set; }
		public string modifiedDate { get; set; }
		public int questionId { get; set; }
		public int updateSeq { get; set; }
	}

	public class busQuestionAnswer : busBase
	{        
        public busUser ibusUser { get; set; }
        public doQuestionAnswer idoQuestionAnswer { get; set; }
		public List<busComment> ilstComments { get; set; }
        public busQuestion ibusQuestion { get; set; }
        public int iintVoteCount { get; set; }
        public int iintUpVoteCount { get; set; }
        public int iintDownVoteCount { get; set; }
		public string istrQuestionAnswerComment { get; set; }
    }
}

