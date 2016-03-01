using System.Linq;

namespace FirstTaste.Steps.Chapter02 {
    public class Calc {
        public int Add(string input) {
            return input.Split('+').Sum(int.Parse);
        }
    }
}