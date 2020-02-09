using System;
using System.Collections.Generic;

namespace CuriousDriveWebAPI.CuriousDrive.Models
{
    public partial class User
    {
        public User()
        {
            Announcement = new HashSet<Announcement>();
            Comment = new HashSet<Comment>();
            Feedback = new HashSet<Feedback>();
            NotificationFromUser = new HashSet<Notification>();
            NotificationToUser = new HashSet<Notification>();
            Point = new HashSet<Point>();
            PostVote = new HashSet<PostVote>();
            Question = new HashSet<Question>();
            QuestionAnswer = new HashSet<QuestionAnswer>();
            QuestionView = new HashSet<QuestionView>();
            TagDetail = new HashSet<TagDetail>();
            UserGroupDetail = new HashSet<UserGroupDetail>();
            UserRole = new HashSet<UserRole>();
        }

        public int UserId { get; set; }
        public string EmailAddress { get; set; }
        public string SaltValue { get; set; }
        public string Password { get; set; }
        public string Otp { get; set; }
        public string IsUserVerified { get; set; }
        public string IsPasswordForgotten { get; set; }
        public int UserStatusId { get; set; }
        public string UserStatusValue { get; set; }
        public string DisplayName { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string PictureUrl { get; set; }
        public int NetworkId { get; set; }
        public string NetworkValue { get; set; }
        public DateTime? BirthDate { get; set; }
        public int? GenderId { get; set; }
        public string GenderValue { get; set; }
        public string PhoneNumber { get; set; }
        public string Occupation { get; set; }
        public string Interests { get; set; }
        public string AboutMe { get; set; }
        public string WebsiteUrl { get; set; }
        public string TwitterUrl { get; set; }
        public string FacebookUrl { get; set; }
        public string InstagramUrl { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }

        public ICollection<Announcement> Announcement { get; set; }
        public ICollection<Comment> Comment { get; set; }
        public ICollection<Feedback> Feedback { get; set; }
        public ICollection<Notification> NotificationFromUser { get; set; }
        public ICollection<Notification> NotificationToUser { get; set; }
        public ICollection<Point> Point { get; set; }
        public ICollection<PostVote> PostVote { get; set; }
        public ICollection<Question> Question { get; set; }
        public ICollection<QuestionAnswer> QuestionAnswer { get; set; }
        public ICollection<QuestionView> QuestionView { get; set; }
        public ICollection<TagDetail> TagDetail { get; set; }
        public ICollection<UserGroupDetail> UserGroupDetail { get; set; }
        public ICollection<UserRole> UserRole { get; set; }
    }
}
