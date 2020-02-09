using System;
using System.Collections.Generic;

namespace CuriousDriveService.Models
{
	public class doComment
	{
		public object istrMode { get; set; }
		public int iintUserId { get; set; }
		public int commentId { get; set; }
		public string commentHtml { get; set; }
		public int subsystemId { get; set; }
		public int subsystemReferenceId { get; set; }
		public string subsystemValue { get; set; }
        public int createdBy { get; set; }
        public string createdDate { get; set; }
        public int modifiedBy { get; set; }
        public string modifiedDate { get; set; }
        public int updateSeq { get; set; }
		public int userId { get; set; }
	}

	public class busComment : busBase
	{        
        public busUser ibusUser { get; set; }
        public busQuestion ibusQuestion { get; set; }
		public doComment idoComment { get; set; }
        public int iintVoteCount { get; set; }
    }
}

