using CuriousDriveWebAPI.CuriousDrive.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class QuestionViewModel
    {
        public int questionId { get; set; }
        public string questionTitle { get; set; }
        public string questionHtml { get; set; }
        public string questionTitleURL { get; set; }
        public string questionComment { get; set; }
        public string questionAnswerHtml { get; set; }
        public int views { get; set; }
        public int upVoteCount { get; set; }
        public int downVoteCount { get; set; }
        public int answerCount { get; set; }
        public DateTime? createdDate { get; set; }
        public bool isOwner { get; set; }        
        public UserDetailsViewModel userDetailsViewModel { get; set; }

        public List<UserTagViewModel> userTagListViewModel { get; set; }
        public List<CommentViewModel> commentsViewModel { get; set; }
        public List<QuestionAnswerViewModel> questionAnswersViewModel { get; set; }
        public List<QuestionClassViewModel> questionClassesViewModel { get; set; }
    }
}
