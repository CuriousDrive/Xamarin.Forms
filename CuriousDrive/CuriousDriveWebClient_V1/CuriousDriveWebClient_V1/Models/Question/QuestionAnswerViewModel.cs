using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class QuestionAnswerViewModel
    {
        public int questionAnswerId { get; set; }
        public int questionId { get; set; }
        public string answerHtml { get; set; }
        public string questionAnswerComment { get; set; }
        public DateTime? createdDate { get; set; }
        public bool isOwner { get; set; }
        public int upVoteCount { get; set; }
        public int downVoteCount { get; set; }
        public UserDetailsViewModel userDetailsViewModel { get; set; }
        public List<CommentViewModel> commentsViewModel { get; set; }
    }
}
