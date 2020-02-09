using CuriousDriveWebAPI.CuriousDrive.Models;
using System.Linq;

namespace CuriousDriveWebAPI.CuriousDrive.Repositories
{
    public class QuestionAnswerRepository : Repository<QuestionAnswer>, IQuestionAnswerRepository
    {
        public QuestionAnswerRepository(CuriousDriveContext context) : base(context)
        {
        }

        public CuriousDriveContext CuriousDriveContext
        {
            get { return Context as CuriousDriveContext; }
        }

        public int GetAnswerCountByQuestionId(int questionId)
        {
            return CuriousDriveContext.QuestionAnswer.Where(questionAnswer => questionAnswer.QuestionId == questionId).Count();
        }
    }
}