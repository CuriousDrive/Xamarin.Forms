using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class UserProfileViewModel
    {
        public string displayName { get; set; }
        public string pictureUrl { get; set; }
        public string networkValue { get; set; }
        public string occupation { get; set; }
        public string aboutMe { get; set; }
        public string facebookUrl { get; set; }
        public string twitterUrl { get; set; }
        public string instagramUrl { get; set; }
        public int totalPoint { get; set; }
        public ProfilePictureViewModel profilePictureViewModel { get; set; }
        public List<UserQuestionViewModel> userQuestionViewModel { get; set; }
        public List<UserQuestionAnswerViewModel> userQuestionAnswerViewModel { get; set; }
        public List<UserCommentViewModel> userCommentViewModel { get; set; }
        public List<NewsFeedViewModel> newsFeedsViewModel { get; set; }
    }
}
