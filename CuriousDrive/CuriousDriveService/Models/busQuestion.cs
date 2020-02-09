using System;
using System.Collections.Generic;

namespace CuriousDriveService.Models
{
    public class doQuestion
    {
        public object istrMode { get; set; }
        public int iintUserId { get; set; }
        public int questionId { get; set; }
        public string questionHtml { get; set; }
        public string questionTitle { get; set; }
        public int threadId { get; set; }
        public int isValid { get; set; }
        public int createdBy { get; set; }
        public string createdDate { get; set; }
        public int modifiedBy { get; set; }
        public string modifiedDate { get; set; }
        public int updateSeq { get; set; }
    }

    public class busQuestion : busBase
    {
        public doQuestion idoQuestion { get; set; }
        public busUser ibusUser { get; set; }
        public List<busQuestionAnswer> ilstQuestionAnswer { get; set; }
        public List<busComment> ilstComments { get; set; }
        public List<busQuestionClass> ilstQuestionClasses { get; set; }
        public List<busTag> ilstbusTags { get; set; }
        public int iintVoteCount { get; set; }
        public int iintUpVoteCount { get; set; }
        public int iintViews { get; set; }
        public int iintDownVoteCount { get; set; }
        public string istrQuestionComment { get; set; }
        public string istrQuestionClasses { get; set; }
        public string istrDropdownClass { get; set; }
        public string istrShortUrl { get; set; }
        public string istrClassIds { get; set; }
        public string istrUserTags { get; set; }
        public string istrQuestionAnswerHtml { get; set; }
        public string istrQuestionTitleURL { get; set; }
        public int iintAnswerCount { get; set; }
    }
}

