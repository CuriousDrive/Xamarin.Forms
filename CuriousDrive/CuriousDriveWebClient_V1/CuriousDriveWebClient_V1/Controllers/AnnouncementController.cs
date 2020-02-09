using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using CuriousDriveWebClient.Attributes;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Http;
using CuriousDriveWebAPI.CuriousDrive;
using CuriousDriveWebAPI.CuriousDrive.Models;

namespace CuriousDriveWebClient.Controllers
{
    public class AnnouncementController : Controller
    {

        #region Announcements

        
        [HttpGet]
        public IActionResult Index(int? pageNumber)
        {
            int pageSize = 10;
            int pageIndex = 1;
            pageIndex = pageNumber.HasValue ? Convert.ToInt32(pageNumber) : 1;

            //AnnouncementService announcementService = new AnnouncementService();
            List<Announcement> llstAnnouncements = null;//announcementService.GetAnnouncements().ToPagedList(pageIndex, pageSize);

            return View(llstAnnouncements);
        }

        [HttpPost]
        public PartialViewResult DisplayAnnouncementsList(string announcementsType)
        {
            //AnnouncementService announcementService = new AnnouncementService();
            List<Announcement> llstAnnouncements = null;//announcementService.GetAnnouncements();

            return PartialView("_AnnouncementsList", llstAnnouncements);
        }

        #endregion

        #region MakeAnAnnouncement

        [HttpGet]
        
        public IActionResult MakeAnAnnouncement(int announcementId)
        {
            Announcement lAnnouncement = null;

            if (announcementId > 0)
            {
                lAnnouncement = new Announcement();//AnnouncementService().GetAnnouncement(aintAnnouncementId);
            }
            return View(lAnnouncement);
        }

        [HttpPost]
        public JsonResult AutoCompleteClasses(string prefix)
        {
            //AdminService adminService = new AdminService();
            List<Class> llstClasses = new List<Class>();  //adminService.GetClasses();

            var lfltrClasses = (from Class in llstClasses
                                   where Class.ClassName.StartsWith(prefix)
                                   select new
                                   {
                                       label = Class.ClassName,
                                       val = Class.ClassId
                                   }).ToList();

            return Json(lfltrClasses);
        }

        [HttpPost]
        public JsonResult AutoCompleteUsers(string prefix)
        {
            String lstrRoleValue = Convert.ToString(HttpContext.Session.GetString("RoleName"));

            var lfltrUsers = new JsonResult(null);//UserService().GetAutocompleteList(prefix, lstrRoleValue);

            return Json(lfltrUsers);
        }

        [HttpPost]
        
        [ValidateAntiForgeryToken]
        public IActionResult MakeAnAnnouncement(FormCollection formCollection, MakeAnAnnouncementViewModel makeAnAnnouncementViewModel, string submitType)
        {
            //AnnouncementService announcementService = new AnnouncementService();
            int lintUserId = HttpContext.Session.GetInt32("UserId") ?? 0;
            Announcement returnedAnnouncement = null;

            if (submitType == "UpdateAnnouncement")
            {
                //new AnnouncementService().UpdateAnnouncement(aAnnouncement, lintUserId);
                return RedirectToAction("Announcement", new
                {
                    id = makeAnAnnouncementViewModel.announcementId,
                    title = ""//announcement.istrAnnouncementTitleURL
                });
            }
            else if (submitType == "CancelUpdateAnnouncement")
            {
                return RedirectToAction("Announcement", new
                {
                    id = makeAnAnnouncementViewModel.announcementId,
                    title = ""
                });
            }
            else
            {
                //aAnnouncement.idoAnnouncement.iintUserId = lintUserId;
                //aAnnouncement.idoAnnouncement.userId = lintUserId;
                //aAnnouncement.istrClassIds = formCollection["txtClassIds"];
                //aAnnouncement.istrUserTags = formCollection["txtUserTags"];

                returnedAnnouncement = new Announcement();//announcementService.InsertAnnouncement(aAnnouncement);
            }

            return View(returnedAnnouncement);
        }

        #endregion

        #region Announcement

        
        [HttpGet]
        
        
        public IActionResult Announcement(int id, string title)
        {
            //perform action if action data has some data and user is logged in
            Message lErrorMessage = PerformActionAfterUserLogin(id);

            //get announcement details 
            int lintUserId = Convert.ToInt32(HttpContext.Session.GetInt32("UserId"));
            Announcement lAnnouncement = new Announcement(); //new AnnouncementService().GetAnnouncementDetails(id, lintUserId);

            //Insert distinct view
            //if (lAnnouncement != null)
            //    InsertAnnouncementView(lAnnouncement.idoAnnouncement.announcementId, lintUserId);

            return View(lAnnouncement);
        }
                
        [HttpPost]
        
        
        public IActionResult Announcement(AnnouncementViewModel announcementViewModel, string submitType)
        {
            string lstrAnnouncementAnswerHtml = string.Empty;
            List<Message> llstMessages = null;
            int lintUserId = Convert.ToInt32(HttpContext.Session.GetInt32("UserId"));

            switch (submitType)
            {
                case "PostAnnouncementComment":
                    Comment lComment = new Comment();//QuestionService().InsertComment(Constant.PostTypeAnnouncement, aAnnouncement.istrAnnouncementComment, aAnnouncement.idoAnnouncement.announcementId, lintUserId);
                    //llstMessages = lComment.ilstMessages;
                    break;

                case "UpdateAnnouncement":
                    //new AnnouncementService().UpdateAnnouncement(aAnnouncement, lintUserId);
                    break;

                default:
                    break;
            }

            ViewData[Constant.ValidationMessages] = llstMessages;
            return RedirectToAction("Announcement", new { id = announcementViewModel.announcementId, title = "" });
        }

        private void InsertAnnouncementView(int aintAnnouncementId, int aintUserId)
        {
            string lstrIPAddress = "";//  new Security().GetIPAddress();
            String userAgent = Request.Headers["User-Agent"];
            string lstrBrowser = ""; //Request.Browser.Browser + '-' + Request.Browser.Version;

            //new AnnouncementService().InsertAnnouncementView(aintAnnouncementId, aintUserId, lstrIPAddress, lstrBrowser);
        }

        public Message PerformActionAfterUserLogin(int id = 0)
        {
            Message lMessage = null;

            //if (HttpContext.Session.GetString("ActionData") != null && HttpContext.Session.GetString("UserId") != null)
            //{
            //    ActionData lActionData = new ActionData(); //(ActionData)HttpContext.Session.GetString("ActionData"];
            //    int lintUserId = Convert.ToInt32(HttpContext.Session.GetInt32("UserId"));

            //    if (lActionData.istrAction == Constant.ActionPostAnnouncementComment)
            //    {
            //        Comment lComment = new QuestionService().InsertComment(Constant.PostTypeAnnouncement, lActionData.istrActionData, lActionData.iintActionId, lintUserId);
            //        if (lComment.ilstMessages != null && lComment.ilstMessages.Count > 0)
            //            lMessage = lComment.ilstMessages[0];
            //        HttpContext.Session.SetString("ActionData", null);
            //    }

            //}

            return lMessage;
        }

        public IActionResult DeleteAnnouncement(int aintAnnouncementId)
        {
            //new AnnouncementService().DeleteAnnouncement(aintAnnouncementId);
            return RedirectToAction("Index", "Announcement");
        }

        #endregion

    }
}
