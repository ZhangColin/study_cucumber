using Microsoft.VisualStudio.TestTools.UnitTesting;
using TechTalk.SpecFlow;

namespace FirstTaste.Steps.Started
{
    [Binding]
    public class CalculatorSteps
    {
        private Calculator _calculator =new Calculator();

        private int _result;

        [Given(@"I have entered (.*) into the calculator")]
        public void GivenIHaveEnteredIntoTheCalculator(int number) {
            _calculator.Numbers.Add(number);
        }
        
        [When(@"I press add")]
        public void WhenIPressAdd() {
            _result = _calculator.Add();
        }
        
        [Then(@"the result should be (.*) on the screen")]
        public void ThenTheResultShouldBeOnTheScreen(int expectedResult)
        {
            Assert.AreEqual(expectedResult, _result);
        }
    }
}
