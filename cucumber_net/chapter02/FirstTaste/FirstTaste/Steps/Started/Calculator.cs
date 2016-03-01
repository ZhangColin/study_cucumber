using System.Collections.Generic;
using System.Linq;

namespace FirstTaste.Steps.Started {
    public class Calculator {
        private readonly IList<int> _numbers = new List<int>();

        public IList<int> Numbers => _numbers;

        public int Add() {
            return _numbers.Sum();
        }
    }
}