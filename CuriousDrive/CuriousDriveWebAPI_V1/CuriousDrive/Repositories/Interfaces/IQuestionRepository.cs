using CuriousDriveWebAPI.CuriousDrive.Models;
using System.Collections.Generic;

namespace CuriousDriveWebAPI.CuriousDrive.Repositories
{
    public interface IQuestionRepository : IRepository<Question>
    {
        List<Question> GetRecentQuestions();
        Question GetQuestionDetails(int questionId);
    }
}