using System;
using System.Collections.Generic;

namespace CuriousDriveService.Models
{
	public class doPostVote
	{
		public object istrMode { get; set; }
		public int iintUserId { get; set; }
		public int postVoteId { get; set; }
        public int questionId { get; set; }
        public int createdBy { get; set; }
		public object createdDate { get; set; }
		public int modifiedBy { get; set; }
		public object modifiedDate { get; set; }
		public int subsystemId { get; set; }
		public int subsystemReferenceId { get; set; }
		public string subsystemValue { get; set; }
		public string subystemValue { get; set; }
		public int updateSeq { get; set; }
		public int userId { get; set; }
		public int voteId { get; set; }
		public string voteValue { get; set; }
	}

	public class busPostVote : busBase
	{
		public doPostVote idoPostVote { get; set; }
	}
}

