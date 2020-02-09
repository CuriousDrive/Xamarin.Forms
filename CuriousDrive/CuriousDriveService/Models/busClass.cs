using System;
using System.Collections.Generic;

namespace CuriousDriveService.Models
{
    public class doClass
    {
        public object istrMode { get; set; }
        public int iintUserId { get; set; }
        public int classId { get; set; }
        public string className { get; set; }
        public string description { get; set; }
        public int createdBy { get; set; }
        public string createdDate { get; set; }
        public int modifiedBy { get; set; }
        public string modifiedDate { get; set; }
        public int updateSeq { get; set; }
    }

	public class busClass : busBase
	{
		public doClass idoClass { get; set; }
		public bool approveClass { get; set; }
		public bool rejectClass { get; set; }
        public List<busClass> ilstbusExistingClasses { get; set; }
    }
}

