using System;
using CuriousDriveService.Models;
using CuriousDriveService.Global;

namespace CuriousDriveService
{
	public class VotesService
	{
		busRestService ibusRestService = null;
		string modularUrl = "/votes";

		public busPostVote InsertVote(object abusPostVote){

			ibusRestService = new busRestService ();
			modularUrl = modularUrl + "/postVotes";	

			return ibusRestService.Post<busPostVote>(modularUrl,abusPostVote);
		}

        public busPostVote InsertVote(int aintQuestionId,string astrSubsystemValue, string astrVoteValue, int aintSubsystemReferenceId, int aintUserId)
        {
            busPostVote lbusPostVote = new busPostVote { idoPostVote = new doPostVote() };

            lbusPostVote.idoPostVote.questionId = aintQuestionId;
            lbusPostVote.idoPostVote.subsystemId = busConstant.PostType;
            lbusPostVote.idoPostVote.subsystemReferenceId = aintSubsystemReferenceId;
            lbusPostVote.idoPostVote.subsystemValue = astrSubsystemValue;
            lbusPostVote.idoPostVote.userId = aintUserId;
            lbusPostVote.idoPostVote.voteId = busConstant.VoteType;
            lbusPostVote.idoPostVote.voteValue = astrVoteValue;
            lbusPostVote.idoPostVote.iintUserId = aintUserId;

            return this.InsertVote(lbusPostVote);
        }
    }
}

