using Microsoft.VisualStudio.TestTools.UnitTesting;
using TechTalk.SpecFlow;

namespace FirstTaste.Steps.Chapter02
{
    [Binding]
    public class 加法Steps {
        private string _input;
        private int _output;

        [Given(@"输入 ""(.*)""")]
        public void 假如输入(string input) {
            _input = input;
        }
        
        [When(@"运行计算器")]
        public void 当运行计算器()
        {
            _output = new Calc().Add(_input);
        }
        
        [Then(@"输出 ""(.*)""")]
        public void 那么输出(int expectedOutput)
        {
            Assert.AreEqual(expectedOutput, _output);
        }
    }
}
