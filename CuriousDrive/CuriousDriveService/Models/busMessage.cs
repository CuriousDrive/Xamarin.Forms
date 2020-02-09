using System;
using System.Collections.Generic;

namespace CuriousDriveService.Models
{
	public class doMessage
	{
		public object istrMode { get; set; }
		public int iintUserId { get; set; }
		public int messageId { get; set; }
		public int createdBy { get; set; }
		public string createdDate { get; set; }
		public string displayMessage { get; set; }
		public object internalInstructions { get; set; }
		public int modifiedBy { get; set; }
		public string modifiedDate { get; set; }
		public string severityId { get; set; }
		public string severityValue { get; set; }
		public int updateSeq { get; set; }
		public object userInstructions { get; set; }
	}

	public class busMessage : busBase
	{
		public doMessage idoMessage { get; set; }
	}

}

