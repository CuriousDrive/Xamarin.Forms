using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Mvc;

namespace CuriousDriveWebClient.Controllers
{
    public class AuthController : Controller
    {
		private readonly IAuthenticationSchemeProvider authenticationSchemeProvider;

		public AuthController(IAuthenticationSchemeProvider authenticationSchemeProvider)
		{
			this.authenticationSchemeProvider = authenticationSchemeProvider;
		}

        public async Task<IActionResult> Login()
        {
			var allSchemeProvider = (await authenticationSchemeProvider.GetAllSchemesAsync())
				.Select(n => n.DisplayName).Where(n => !String.IsNullOrEmpty(n));

			return View(allSchemeProvider);
        }

		public IActionResult SignIn(String provider)
		{
            ChallengeResult challengeResult = Challenge(new AuthenticationProperties { RedirectUri = "/" }, provider); ;
            return challengeResult;

        }

		public async Task<IActionResult> SignOut()
		{
			await HttpContext.SignOutAsync(CookieAuthenticationDefaults.AuthenticationScheme);
			return RedirectToAction("Questions", "Question");
		}
	}
}