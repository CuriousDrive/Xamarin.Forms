using System;
using System.Globalization;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;
using System.Web;
using System.Security.Cryptography;
using Newtonsoft.Json;
using System.Diagnostics;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Http;
using CuriousDriveWebAPI.CuriousDrive.UnitsOfWork;
using CuriousDriveWebAPI.CuriousDrive.Models;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authentication.Cookies;
using CuriousDriveWebAPI.CuriousDrive;
using System.Collections.ObjectModel;

namespace CuriousDriveWebClient.Controllers
{
    [Authorize]
    public class AccountController : Controller
    {
        #region Initialization

        private readonly IAuthenticationSchemeProvider authenticationSchemeProvider;

        public AccountController(IAuthenticationSchemeProvider authenticationSchemeProvider)
        {
            this.authenticationSchemeProvider = authenticationSchemeProvider;
        }

        #endregion

        #region Login
        // GET: /Account/Login
        [AllowAnonymous]
        [HttpGet]
        public async Task<IActionResult> Login()
        {
            LoginViewModel loginViewModel = new LoginViewModel();

            loginViewModel.AllSchemeProvider = (await authenticationSchemeProvider.GetAllSchemesAsync())
                .Select(n => n.DisplayName).Where(n => !String.IsNullOrEmpty(n));           

            if (User.Identity.IsAuthenticated == true)
            {                
                using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
                {
                    //Login
                    CuriousDriveWebAPI.CuriousDrive.Models.User user = unitOfWork.Users.GetSocialNetworkUserByEmailAddress(User.Claims.Where(claim => claim.Type == ClaimTypes.Email).FirstOrDefault().Value);

                    if (user != null)
                    {
                        LoadSession(user);
                        return RedirectToAction("Questions", "Question");
                    }
                    else
                    {
                        //Register and then login
                        user = new User();
                        string saltValue = Security.GetSaltValue();
                        MD5 md5Hash = MD5.Create();

                        user.EmailAddress = User.Claims.Where(claim => claim.Type == ClaimTypes.Email).FirstOrDefault().Value;
                        user.FirstName = User.Claims.Where(claim => claim.Type == ClaimTypes.GivenName).FirstOrDefault().Value;
                        user.LastName = User.Claims.Where(claim => claim.Type == ClaimTypes.Surname).FirstOrDefault().Value;
                        user.DisplayName = User.Claims.Where(claim => claim.Type == ClaimTypes.Name).FirstOrDefault().Value;
                        user.Password = Security.GetMd5Hash(md5Hash, saltValue + user.EmailAddress);
                        user.SaltValue = Security.Encrypt(saltValue);
                        user.IsUserVerified = Constant.FlagY;
                        user.IsPasswordForgotten = Constant.FlagN;
                        user.UserStatusId = Constant.UserStatusId;
                        user.UserStatusValue = Constant.Active;
                        user.NetworkId = Constant.NetworkId;

                        if (User.Identity.AuthenticationType == "Facebook")
                            user.NetworkValue = Constant.FacebookNetwork;
                        if (User.Identity.AuthenticationType == "Google")
                            user.NetworkValue = Constant.GoogleNetwork;

                        user.CreatedBy = user.ModifiedBy = 1;

                        user.UserRole = new Collection<CuriousDriveWebAPI.CuriousDrive.Models.UserRole>();
                        UserRole userRole = new UserRole();

                        userRole.RoleId = unitOfWork.Roles.Find(role => role.RoleName == Constant.RoleStudent).FirstOrDefault().RoleId;
                        userRole.CreatedBy = user.ModifiedBy = 1;

                        user.UserRole.Add(userRole);
                        unitOfWork.Users.Add(user);

                        unitOfWork.Complete();

                        LoadSession(user);
                        return RedirectToAction("Questions", "Question");
                    }                    
                }
            }

            return View(loginViewModel);
        }

        // POST: /Account/Login
        [HttpPost]
        [AllowAnonymous]
        public IActionResult Login(LoginViewModel loginViewModel, string submitType)
        {
            //UpdateUserPasswords(aUser);

            if (!submitType.Equals("Login"))
            {
                ChallengeResult challengeResult = Challenge(new AuthenticationProperties { RedirectUri = "/" }, submitType); ;
                return challengeResult;
            }
           
            using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
            {                
                //get salt value
                string encryptedSaltValue = unitOfWork.Users.GetSaltValueByEmailAddress(loginViewModel.EmailAddress);

                if (encryptedSaltValue != null && !encryptedSaltValue.Equals(""))
                {
                    //decrypt the salt value with symmetric algorithm
                    string saltValue = Security.Decrypt(encryptedSaltValue);

                    //append it with the password entered by the user and encrypt the the password with MD5
                    MD5 md5Hash = MD5.Create();
                    loginViewModel.Password = Security.GetMd5Hash(md5Hash, saltValue + loginViewModel.Password);
                    
                    User user = unitOfWork.Users.GetUserByEmailAddressAndPassword(loginViewModel.EmailAddress, loginViewModel.Password);
                    LoadSession(user);

                    return RedirectToAction("Questions", "Question");                    
                }
                else
                {
                    return View();
                }
            }
        }

        private void UpdateUserPasswords(User aUser)
        {
            //get OTP
            //aUser.istrPlainOtp = Security.GenerateRandomOTP(6);

            ////testing encryption and decryption of the opt and email address 
            //aUser.istrEmailVerificationCode = Security.Encrypt(aUser.istrPlainOtp + "#" + aUser.idoUser.emailAddress);

            ////encrypt the OTP
            //MD5 md5Hash = MD5.Create();
            //string encryptedOTP = Security.GetMd5Hash(md5Hash, aUser.istrPlainOtp);
            //aUser.idoUser.otp = encryptedOTP;


            //string lstrSaltValue = Security.GetSaltValue();
            //string lstrSaltedPassword = lstrSaltValue + aUser.idoUser.password;

            //aUser.idoUser.password = Security.GetMd5Hash(md5Hash, lstrSaltedPassword);
            //aUser.idoUser.saltValue = Security.Encrypt(lstrSaltValue);

            //Debug.WriteLine("email address = " + aUser.idoUser.emailAddress);
            //Debug.WriteLine("salt value = " + Security.Encrypt(lstrSaltValue));
            //Debug.WriteLine("password = " + aUser.idoUser.password);
            //Debug.WriteLine("otp = " + aUser.idoUser.otp);
        }

        public void LoadSession(User user)
        {
            HttpContext.Session.SetString("EmailAddress",user.EmailAddress ?? "");
            HttpContext.Session.SetInt32("UserId",user.UserId);
            HttpContext.Session.SetString("DisplayName",user.DisplayName ?? "");
            HttpContext.Session.SetString("NetworkValue",user.NetworkValue ?? "");
            HttpContext.Session.SetString("UrlTitle",Utility.GetURLTitle(user.DisplayName) ?? "");
            HttpContext.Session.SetString("PictureUrl",user.PictureUrl ?? "");
            HttpContext.Session.SetString("RoleName",user.UserRole.FirstOrDefault().Role.RoleName ?? "");
        }

        #endregion

        #region ForgotPassword

        // GET: /Account/ForgotPassword
        [AllowAnonymous]
        public IActionResult ForgotPassword()
        {
            return View();
        }

        //
        // POST: /Account/ForgotPassword
        [HttpPost]
        [AllowAnonymous]
        [ValidateAntiForgeryToken]
        public IActionResult ForgotPassword(ForgotPasswordViewModel forgotPasswordViewModel)
        {
            // get OTP
            forgotPasswordViewModel.plainOTP = Security.GenerateRandomOTP(6);

            ////testing encryption and decryption of the opt and email address 
            forgotPasswordViewModel.emailVerificationCode = Security.Encrypt(forgotPasswordViewModel.plainOTP + "#" + forgotPasswordViewModel.emailAddress);

            ////encrypt the OTP
            forgotPasswordViewModel.otp = Security.GetMd5Hash(MD5.Create(), forgotPasswordViewModel.plainOTP);

            //aUser = new UserService().ForgotPassword(aUser);

            //if (aUser.ilstMessages.Count == 0)
            //    return RedirectToAction("ForgotPasswordConfirmation", "Account");
            //else
            //    return View(aUser);

            return View(forgotPasswordViewModel);
        }

        // GET: /Account/ForgotPasswordConfirmation
        [AllowAnonymous]
        [HttpGet]
        public IActionResult ForgotPasswordConfirmation()
        {
            return View();
        }

        #endregion

        #region ResetPassword

        // GET: /Account/ResetPassword
        [AllowAnonymous]
        [HttpGet]
        public IActionResult ResetPassword([FromQuery(Name = "key")] string key)
        {
            User lUser = new User(); //{ idoUser = new doUser() };

            try
            {
                key = key.Replace(' ', '+');
                string lstrEmailVerifcationCode = Security.Decrypt(key);

                string[] larrlstrEmailVerifcationCode;

                if (lstrEmailVerifcationCode != "" && lstrEmailVerifcationCode.Split('#').Count() == 2)
                {
                    larrlstrEmailVerifcationCode = lstrEmailVerifcationCode.Split('#');

                    //lUser.istrPlainOtp = larrlstrEmailVerifcationCode[0];
                    //lUser.idoUser.emailAddress = larrlstrEmailVerifcationCode[1];

                    MD5 md5Hash = MD5.Create();
                    //lUser.idoUser.otp = Security.GetMd5Hash(md5Hash, lUser.istrPlainOtp);

                    lUser = new User();//UserService().GetUserByEmailAndOTP(lUser);
                }
            }
            catch (Exception ex)
            {
                Debug.WriteLine(ex.Message);
            }

            //if (lUser.idoUser.userId == 0)
            //    lUser.AddMessage(Constant.SystemCannotFindTheAccount);

            return View(lUser);
        }

        // POST: /Account/ResetPassword
        [HttpPost]
        [AllowAnonymous]        
        public IActionResult ResetPassword(ResetPasswordViewModel resetPasswordViewModel)
        {
            //if (aUser.ValidateNewPassword())
            //{
            //    string lstrSaltValue = Security.GetSaltValue();
            //    string lstrSaltedPassword = lstrSaltValue + aUser.idoUser.password;

            //    MD5 md5Hash = MD5.Create();
            //    aUser.idoUser.password = Security.GetMd5Hash(md5Hash, lstrSaltedPassword);
            //    aUser.idoUser.saltValue = Security.Encrypt(lstrSaltValue);
            //    aUser.idoUser.isPasswordForgotten = Constant.FlagY;

            //    aUser = new UserService().SetNewPassword(aUser);

            //    return RedirectToAction("ResetPasswordConfirmation", "Account");
            //}
            //else
            return View(resetPasswordViewModel);
        }

        // GET: /Account/ResetPasswordConfirmation
        [AllowAnonymous]
        public IActionResult ResetPasswordConfirmation()
        {
            return View();
        }

        #endregion

        #region Register
        // POST: /Account/Register
        [HttpPost]
        [AllowAnonymous]
        public IActionResult Register(RegisterViewModel registerViewModel, string submitType)
        {
            if (!submitType.Equals("Register"))
            {
                ChallengeResult challengeResult = Challenge(new AuthenticationProperties { RedirectUri = "/" }, submitType); ;
                return challengeResult;
            }
            {
                using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
                {
                    // Register and then login
                    User user = new User();
                    string saltValue = Security.GetSaltValue();
                    MD5 md5Hash = MD5.Create();

                    user.EmailAddress = registerViewModel.emailAddress;
                    user.Password = Security.GetMd5Hash(md5Hash, saltValue + registerViewModel.password);
                    user.SaltValue = Security.Encrypt(saltValue);
                    user.IsUserVerified = Constant.FlagN;
                    user.IsPasswordForgotten = Constant.FlagN;
                    user.UserStatusId = Constant.UserStatusId;
                    user.UserStatusValue = Constant.Active;
                    user.NetworkId = Constant.NetworkId;
                    user.NetworkValue = Constant.ApplicationNetwork;

                    user.CreatedBy = user.ModifiedBy = 1;

                    user.UserRole = new Collection<CuriousDriveWebAPI.CuriousDrive.Models.UserRole>();
                    UserRole userRole = new UserRole();

                    userRole.RoleId = unitOfWork.Roles.Find(role => role.RoleName == Constant.RoleStudent).FirstOrDefault().RoleId;
                    userRole.CreatedBy = user.ModifiedBy = 1;

                    user.UserRole.Add(userRole);
                    unitOfWork.Users.Add(user);

                    unitOfWork.Complete();

                    LoadSession(user);
                    return RedirectToAction("Questions", "Question");
                }                
            }
        }

        // GET: /Account/ResetPasswordConfirmation
        [AllowAnonymous]
        public async Task<IActionResult> Register()
        {
            RegisterViewModel registerViewModel = new RegisterViewModel();

            registerViewModel.AllSchemeProvider = (await authenticationSchemeProvider.GetAllSchemesAsync())
                .Select(n => n.DisplayName).Where(n => !String.IsNullOrEmpty(n));

            if (User.Identity.IsAuthenticated == true)
            {
                using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
                {
                    //Login
                    CuriousDriveWebAPI.CuriousDrive.Models.User user = unitOfWork.Users.GetSocialNetworkUserByEmailAddress(User.Claims.Where(claim => claim.Type == ClaimTypes.Email).FirstOrDefault().Value);

                    if (user != null)
                    {
                        LoadSession(user);
                        return RedirectToAction("Questions", "Question");
                    }
                    else
                    {
                        //Register and then login
                        user = new User();
                        string saltValue = Security.GetSaltValue();
                        MD5 md5Hash = MD5.Create();

                        user.EmailAddress = User.Claims.Where(claim => claim.Type == ClaimTypes.Email).FirstOrDefault().Value;
                        user.FirstName = User.Claims.Where(claim => claim.Type == ClaimTypes.GivenName).FirstOrDefault().Value;
                        user.LastName = User.Claims.Where(claim => claim.Type == ClaimTypes.Surname).FirstOrDefault().Value;
                        user.DisplayName = User.Claims.Where(claim => claim.Type == ClaimTypes.Name).FirstOrDefault().Value;
                        user.Password = Security.GetMd5Hash(md5Hash, saltValue + user.EmailAddress);
                        user.SaltValue = Security.Encrypt(saltValue);
                        user.IsUserVerified = Constant.FlagY;
                        user.IsPasswordForgotten = Constant.FlagN;
                        user.UserStatusId = Constant.UserStatusId;
                        user.UserStatusValue = Constant.Active;
                        user.NetworkId = Constant.NetworkId;

                        if (User.Identity.AuthenticationType == "Facebook")
                            user.NetworkValue = Constant.FacebookNetwork;
                        if (User.Identity.AuthenticationType == "Google")
                            user.NetworkValue = Constant.GoogleNetwork;

                        user.CreatedBy = user.ModifiedBy = 1;

                        user.UserRole = new Collection<CuriousDriveWebAPI.CuriousDrive.Models.UserRole>();
                        UserRole userRole = new UserRole();

                        userRole.RoleId = unitOfWork.Roles.Find(role => role.RoleName == Constant.RoleStudent).FirstOrDefault().RoleId;
                        userRole.CreatedBy = user.ModifiedBy = 1;

                        user.UserRole.Add(userRole);
                        unitOfWork.Users.Add(user);

                        unitOfWork.Complete();

                        LoadSession(user);
                        return RedirectToAction("Questions", "Question");
                    }
                }
            }

            return View(registerViewModel);
        }

        #endregion

        #region VerifyAccount

        // GET: /Account/VerifyAccount
        [AllowAnonymous]
        [HttpGet]
        public IActionResult VerifyAccount([FromQuery(Name = "key")] string key)
        {
            User lUser = new User(); //{ idoUser = new doUser() };

            try
            {
                key = key.Replace(' ', '+');
                string lstrEmailVerifcationCode = Security.Decrypt(key);

                string[] larrlstrEmailVerifcationCode;

                if (lstrEmailVerifcationCode != "" && lstrEmailVerifcationCode.Split('#').Count() == 2)
                {
                    larrlstrEmailVerifcationCode = lstrEmailVerifcationCode.Split('#');

                    //lUser.istrPlainOtp = larrlstrEmailVerifcationCode[0];
                    //lUser.idoUser.emailAddress = larrlstrEmailVerifcationCode[1];

                    MD5 md5Hash = MD5.Create();
                    //lUser.idoUser.otp = Security.GetMd5Hash(md5Hash, lUser.istrPlainOtp);

                    lUser = new User();//UserService().GetUserByEmailAndOTP(lUser);
                }
            }
            catch (Exception ex)
            {
                Debug.WriteLine(ex.Message);
            }

            //if (lUser.idoUser.userId == 0)
            //    lUser.AddMessage(Constant.SystemCannotFindTheAccount);

            return View(lUser);
        }

        // POST: /Account/VerifyAccount
        [HttpPost]
        [AllowAnonymous]
        [ValidateAntiForgeryToken]
        public IActionResult VerifyAccount(VerifyAccountViewModel verifyAccountViewModel)
        {
            //if (aUser.ValidateNewPassword())
            //{
            //    string lstrSaltValue = Security.GetSaltValue();
            //    string lstrSaltedPassword = lstrSaltValue + aUser.idoUser.password;

            //    MD5 md5Hash = MD5.Create();
            //    aUser.idoUser.password = Security.GetMd5Hash(md5Hash, lstrSaltedPassword);
            //    aUser.idoUser.saltValue = Security.Encrypt(lstrSaltValue);
            //    aUser.idoUser.isUserVerified = Constant.FlagY;

            //    aUser = new UserService().SetNewPassword(aUser);

            //    return RedirectToAction("VerifyAccountConfirmation", "Account");
            //}
            //else
            return View(verifyAccountViewModel);
        }

        // GET: /Account/VerifyAccountConfirmation
        [AllowAnonymous]
        [HttpGet]
        public IActionResult VerifyAccountConfirmation()
        {
            return View();
        }

        #endregion

        #region LogOff

        //
        // POST: /Account/LogOff
        [HttpGet]
        [AllowAnonymous]
        //[ValidateAntiForgeryToken]
        public async Task<IActionResult> LogOff()
        {
            await HttpContext.SignOutAsync(CookieAuthenticationDefaults.AuthenticationScheme);
            HttpContext.Session.Clear();
            return RedirectToAction("Login", "Account");
        }


        #endregion

        #region Helpers
        
        private IActionResult RedirectToLocal(string returnUrl)
        {
            if (Url.IsLocalUrl(returnUrl))
            {
                return Redirect(returnUrl);
            }
            return RedirectToAction("Index", "Question");
        }

        private IActionResult RedirectToActionData()
        {
            //ActionData lActionData = new ActionData(); //(ActionData)HttpContext.Session.Get ("ActionData"];
            //if (lActionData.istrRedirectActionName == "Question")
            //{
            //    Question lQuestion = new QuestionService().GetQuestion(lActionData.iintId);
            //    return RedirectToAction(lActionData.istrRedirectActionName, lActionData.istrRedirectControllerName, new
            //    {
            //        id = lActionData.iintId,
            //        title = lQuestion.istrQuestionTitleURL
            //    });
            //}
            //else
            //    return RedirectToAction(lActionData.istrRedirectActionName, lActionData.istrRedirectControllerName, new { id = lActionData.iintId });

            return View();
        }

        #endregion
    }
}