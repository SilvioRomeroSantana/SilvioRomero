using System;
using System.Collections.Generic;

namespace ConsoleApp1
{
    class Program
    {
        private static int GetMaxDiffInArray(List<int> array)
        {
            //Guarda o menor valor encontrado ate agora
            int? minValue = null;

            //Guarda a maior diferenca encontrada ate agora
            int maxDiff = 0;


            foreach (int elemento in array)
            { 
                //Caso o elemento seja o segundo da lista para a frente
                if (minValue.HasValue)
                {
                    //Calcuo a diferenca entre o elemento atual e o menor que ja foi encontrado até agora
                    var diffValue = elemento - minValue.Value;

                    //Caso a diferenca seja maior que 0, essa será a nova diferenca
                    maxDiff = (diffValue > maxDiff) ? diffValue : maxDiff;

                    //Caso o elemento atual seja menor que o menor já encontrado até agora, ele será o novo menor elemento
                    minValue = elemento < minValue ? elemento : minValue;
                }
                //Se a variavel minValue ainda não tem valor, essa é a primeira iteração do array e não ha como comparar um elemento com seus anteriores
                //logo, esse elemento é o menor econtrado até agora
                else
                    minValue = elemento;
            };

            //Caso nenhuma diferenca > 0 seja encontrada, retornamos -1
            return maxDiff == 0 ? -1 : maxDiff;
        }

        static void Main(string[] args)
        {
            //casos de teste:
            //1º elemento: id do teste (usado para debug)
            //2º elemento: array de inteiros usados para testar logica da funcionalidade criada
            //3º elemento: resultado esperado
            List<(int, List<int>, int)> testCases = new List<(int, List<int>, int)>()
            {
                (1, new List<int> { 1}, -1),
                (2, new List<int> { }, -1),
                (3, new List<int> { 1, 2, 3, 4, 5, 6 }, 5),
                (4, new List<int> { 1, 20, -3, 4, 15, 22}, 25),
                (5, new List<int> { -10, 2, 30, 4, 105, 6}, 115),
                (6, new List<int> { -10, 2, 30, -20, 105, 6}, 125),
                (7, new List<int> { 3, 2, 1}, -1),
                (8, new List<int> { 2, 2, 2}, -1),
                (9, new List<int> { 2, 2, 1}, -1),
                (10, new List<int> { -5, 20, 60, -20, -500, 900, -500 }, 1400),
                (11, new List<int> { -5, 20, 60, -20, -500, 900, 5000}, 5500),
                (12, new List<int> {  2, 3, 10, 2, 4, 8, 1}, 9),
                (13, new List<int> {  7, 9, 5, 6, 3, 2}, 2)
            };

            //Roda a funcionalidade principal para cada caso de teste
            foreach ((int, List<int>, int) testCase in testCases)
            {
                int result = GetMaxDiffInArray(testCase.Item2);
               
                if (result != testCase.Item3)
                    Console.WriteLine("Erro, Valor esperado: {0}, Valor Calculado: {1}, para teste de Id: {0}", testCase.Item3, result, testCase.Item1);
                else
                    Console.WriteLine("Sucesso, Resultado: {0}", result);
            }

            Console.ReadKey();
        }
    }
}
