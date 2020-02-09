using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using Microsoft.AspNetCore.Mvc;
using CuriousDriveWebClient.Attributes;
using Microsoft.AspNetCore.Http;
using CuriousDriveWebAPI.CuriousDrive;
using CuriousDriveWebAPI.CuriousDrive.Models;
using CuriousDriveWebAPI.CuriousDrive.UnitsOfWork;

namespace CuriousDriveWebClient.Controllers
{
    public class AdminController : Controller
    {
        #region Feedback
                
        [HttpGet]
        public IActionResult SubmitFeedback()
        {
            SubmitFeedbackViewModel submitFeedbackViewModel = new SubmitFeedbackViewModel();//AdminService().loadVerifiedFeedbacks();
            return View(submitFeedbackViewModel);
        }

        [HttpPost]
        public IActionResult SubmitFeedback(SubmitFeedbackViewModel submitFeedbackViewModel)
        {
            int userId = HttpContext.Session.GetInt32("UserId") ?? 0;
            submitFeedbackViewModel.userId = userId;

            using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
            {
                Feedback feedback = new Feedback();
                feedback.FeedbackText = submitFeedbackViewModel.feedback;                
                feedback.CreatedBy = feedback.ModifiedBy = feedback.UserId = userId;

                unitOfWork.Feedback.Add(feedback);

                unitOfWork.Complete();
            }

            return RedirectToAction("SubmitFeedback", "Admin");
        }
                
        [HttpGet]
        public IActionResult Feedback()
        {
            FeedbackViewModel feedbackViewModel = new FeedbackViewModel();//AdminService().loadVerifiedFeedbacks();
            return View(feedbackViewModel);
        }

        [HttpPost]
        public IActionResult Feedback(FeedbackViewModel feedbackViewModel, string submitType)
        {
            return View();
        }

        #endregion

        #region AboutUs

        
        [HttpGet]
        public IActionResult AboutUs()
        {
            return View();
        }

        #endregion

        #region HelpCenter

        
        [HttpGet]
        public IActionResult HelpCenter()
        {
            return View();
        }

        #endregion

        #region Class

        [HttpGet]        
        public IActionResult AddClass()
        {
            AddClassViewModel addClassViewModel = new AddClassViewModel();
            addClassViewModel.classesViewModel = new List<ClassViewModel>();

            using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
            {
                List<Class> classes = unitOfWork.Classes.GetAll().ToList();

                foreach (Class @class in classes)
                {
                    ClassViewModel classViewModel = new ClassViewModel();

                    classViewModel.classId = @class.ClassId;
                    classViewModel.className = @class.ClassName;
                    classViewModel.description = @class.Description;

                    addClassViewModel.classesViewModel.Add(classViewModel);

                }
            }

            return View(addClassViewModel);
        }

        [HttpPost]        
        public IActionResult AddClass(AddClassViewModel addClassViewModel)
        {
            int userId = Convert.ToInt32(HttpContext.Session.GetInt32("UserId"));

            using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
            {
                Class @class = new Class();

                @class.ClassName = addClassViewModel.className;
                @class.Description = addClassViewModel.description;
                @class.CreatedBy = @class.ModifiedBy = userId;

                unitOfWork.Classes.Add(@class);

                unitOfWork.Complete();

            }

            return RedirectToAction("AddClass","Admin");
        }

        
        public IActionResult DeleteClass(int classId)
        {
            using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
            {
                Class @class = unitOfWork.Classes.Get(classId);
                List<QuestionClass> questionClasses = unitOfWork.QuestionClasses.Find(questionClass => questionClass.ClassId == classId).ToList();

                unitOfWork.QuestionClasses.RemoveRange(questionClasses);
                unitOfWork.Classes.Remove(@class);

                unitOfWork.Complete();
            }

            return RedirectToAction("AddClass");

        }

        #endregion

        #region UserGroups
                
        [HttpGet]
        
        
        public IActionResult CreateUserGroup(int userGroupId)
        {
            UserGroup lUserGroup = new UserGroup();

            if (userGroupId > 0)
            {
                //lUserGroup = new AdminService().GetUserGroup(aintUserGroupId);
            }
            return View(lUserGroup);
        }

        [HttpPost]
        
        
        [ValidateAntiForgeryToken]
        public IActionResult CreateUserGroup(FormCollection formCollection, CreateUserGroupViewModel createUserGroupViewModel)
        {
            //aUserGroup.istrUserIds = formCollection["txtUserIds"];
            //aUserGroup.idoUserGroup.iintUserId = Convert.ToInt32(HttpContext.Session.GetInt32("UserId"));

            //if (aUserGroup.idoUserGroup.userGroupId == 0)
            //{
            //    aUserGroup = new AdminService().CreateUserGroup(aUserGroup);

            //    if (aUserGroup.ilstMessages != null && !aUserGroup.ilstMessages.Any(lMessage => lMessage.idoMessage.severityValue == "ERRR"))
            //    {
            //        ViewData[Constant.ValidationMessages] = aUserGroup.ilstMessages;
            //        return RedirectToAction("CreateUserGroup", new { aintUserGroupId = 0 });
            //    }
            //    else
            //    {
            //        return View(aUserGroup);
            //    }
            //}

            //else
            //{
            //    aUserGroup = new AdminService().UpdateUserGroup(aUserGroup);

            //    if (aUserGroup.ilstMessages != null && !aUserGroup.ilstMessages.Any(lMessage => lMessage.idoMessage.severityValue == "ERRR"))
            //    {
            //        ViewData[Constant.ValidationMessages] = aUserGroup.ilstMessages;
            //        return RedirectToAction("UserGroups");
            //    }
            //    else
            //    {
            //        return View(aUserGroup);
            //    }
            //}

            return View();
        }
        
        public JsonResult GetUserGroupUsers(int userGroupId)
        {
            //UserGroup lUserGroup = null;
            //lUserGroup = new AdminService().GetUserGroup(aintUserGroupId);

            //return Json(lUserGroup.ilstUserGroupDetail);

            return Json(null);
        }
        
        [HttpPost]
        
        [ValidateAntiForgeryToken]
        public IActionResult DeleteUserGroupDetail(int userGroupDetailId)
        {
            //new AdminService().DeleteClass(aintUserGroupDetailId);

            return View();
        }
                
        [HttpGet]
        
        
        public IActionResult UserGroups()
        {
            UserGroup lUserGroup = new UserGroup();
            //lUserGroup.ilstExistingUserGroups = new AdminService().GetUserGroupsByName(string.Empty);
            return View(lUserGroup);
        }

        [HttpPost]
        
        [ValidateAntiForgeryToken]
        public IActionResult UserGroups(FormCollection formCollection)
        {
            string astrSearchTerm = formCollection["txtSearch"];
            UserGroup lUserGroup = new UserGroup();
            //lUserGroup.ilstExistingUserGroups = new AdminService().GetUserGroupsByName(astrSearchTerm);

            return View(lUserGroup);
        }

        

        #endregion

        #region EnrollUser

        [HttpGet]
        
        
        public IActionResult EnrollUser()
        {
            return View(new EnrollUserViewModel());
        }

        [HttpPost]
        
        [ValidateAntiForgeryToken]
        public IActionResult EnrollUser(EnrollUserViewModel enrollUserViewModel)
        {
            //get OTP
            //aUser.istrPlainOtp = Security.GenerateRandomOTP(6);

            ////testing encryption and decryption of the opt and email address 
            //aUser.istrEmailVerificationCode = Security.Encrypt(aUser.istrPlainOtp + "#" + aUser.idoUser.emailAddress);

            ////encrypt the OTP
            //MD5 md5Hash = MD5.Create();
            //string encryptedOTP = Security.GetMd5Hash(md5Hash, aUser.istrPlainOtp);
            //aUser.idoUser.otp = encryptedOTP;

            ////save user info in the database and send OTP to the user on his/her email address
            //aUser.idoUser.isUserVerified = Constant.FlagN;
            //aUser.idoUser.isPasswordForgotten = Constant.FlagN;
            //aUser.idoUser.userStatusId = Constant.UserStatusId;
            //aUser.idoUser.userStatusValue = Constant.Inactive;
            //aUser.idoUser.genderId = Constant.GenderId;

            //aUser = new UserService().Enroll(aUser);

            //if (aUser.ilstMessages != null && !aUser.ilstMessages.Any(lMessage => lMessage.idoMessage.severityValue == "ERRR"))
            //{
            //    ViewData[Constant.ValidationMessages] = aUser.ilstMessages;
            //    return RedirectToAction("EnrollUser");
            //}
            //else
            //{
            //    return View(aUser);
            //}

            return View();
        }

        #endregion

    }
}