using CuriousDriveWebAPI.CuriousDrive.Models;

namespace CuriousDriveWebAPI.CuriousDrive.Repositories
{
    public interface IQuestionAnswerRepository : IRepository<QuestionAnswer>
    {
        int GetAnswerCountByQuestionId(int questionId);
    }
}