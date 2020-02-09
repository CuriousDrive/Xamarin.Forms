using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CuriousDriveService.Models
{
    public class idoAnnouncement
    {
        public object istrMode { get; set; }
        public int iintUserId { get; set; }
        public int announcementId { get; set; }
        public int userId { get; set; }
        public string announcementTitle { get; set; }
        public string announcementHtml { get; set; }
        public int createdBy { get; set; }
        public string createdDate { get; set; }
        public int modifiedBy { get; set; }
        public string modifiedDate { get; set; }
        public int updateSeq { get; set; }
    }

    public class busAnnouncement : busBase
    {
        public idoAnnouncement idoAnnouncement { get; set; }
        public List<busComment> ilstComments { get; set; }
        public List<busTag> ilstbusTags { get; set; }
        public busUser ibusUser { get; set; }
        public string istrAnnouncementTitleURL { get; set; }
        public string istrClassIds { get; set; }
        public string istrUserTags { get; set; }
        public string istrAnnouncementComment { get; set; }
        public int iintViews { get; set; }
    }
}
