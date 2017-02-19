using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Predictor
{
    class Program
    {
        public static int getRating(double[] vector) //
        {

            //Start
            Console.WriteLine("Creating a 4-6-3 neural network");
            Console.WriteLine("Using tanh and softmax activations");
            const int numInput = 46;
            const int numHidden = 3;
            const int numOutput = 5;
            ann nn =
            new ann(numInput, numHidden, numOutput);

            // training parameters specific to EO
            int popSize = 25;
            int maxGeneration = 5500;
            double exitError = 0.0;
            double mutateRate = 0.09999999;
            double mutateChange = 5.905; //0.005
            double tau = 0.40;

            // int popSize = 25;
            //  int maxGeneration = 5500;
            //  double exitError = 0.0;
            //  double mutateRate = 0.09999999;
            //  double mutateChange = 5.905; //0.005
            //   double tau = 0.40;

            Console.WriteLine("\nSetting popSize = " + popSize);
            Console.WriteLine("Setting maxGeneration = " + maxGeneration);
            Console.Write("Setting early exit MSE error = ");
            Console.WriteLine(exitError.ToString("F3"));
            Console.Write("Setting mutateRate = ");
            Console.WriteLine(mutateRate.ToString("F3"));
            Console.Write("Setting mutateChange = ");
            Console.WriteLine(mutateChange.ToString("F3"));
            Console.Write("Setting tau = ");
            Console.WriteLine(tau.ToString("F3"));

            double[][] allData = LoadData("C:\\Users\\infer\\Desktop\\Fall16\\BigData\\Project\\finalData\\input.csv", 10181, 51); // 150 rows, 7 cols
            Console.WriteLine("Aim is to predict the range of IMBD Rating For an movie");
            Console.WriteLine("Factors Considered Actors, Directors, Writers, IMDB Votes, FB Fan Count, FB Fan Votes, Twitter Votes, Year Of Release, Genre, Type (Movie, Episode, Series)");
            Console.WriteLine("Ratings in range of 0-2 / Out 0, 2-4 / Out 1, 4-6 / Out 2, 6-8 / Out 3, 8-10 / Out 4");
            Console.WriteLine("\nThe 150-item data set is:\n");
            // ShowMatrix(allData, 4, 1, true);

            double[][] trainData = null;
            double[][] testData = null;
            double trainPct = 0.70;
            int splitSeed = 1;
            Console.WriteLine("Splitting data into 70% train, 30% test");
            SplitData(allData, trainPct, splitSeed, out trainData, out testData);
            //   Console.WriteLine("\nThe training data is:\n");
            //  ShowMatrix(trainData, 4, 1, true);
            //  Console.WriteLine("The test data is:\n");
            //  ShowMatrix(testData, 3, 1, true);

            Console.WriteLine("\nBeginning training");
            double[] bestWeights = nn.Train(trainData, popSize, maxGeneration, exitError,
            mutateRate, mutateChange, tau);
            Console.WriteLine("Training complete");
            Console.WriteLine("\nFinal weights and bias values:");
            ShowVector(bestWeights, 10, 3, true);





            nn.SetWeights(bestWeights);
            double trainAcc = nn.Accuracy(trainData);
            Console.Write("\nAccuracy on training data = ");
            Console.WriteLine(trainAcc.ToString("F4"));

            double testAcc = nn.Accuracy(testData);
            Console.Write("\nAccuracy on test data = ");
            Console.WriteLine(testAcc.ToString("F4"));


            Console.WriteLine("\nTESTING Our OWN Data");
            //need to implement for soecific Film
            double[] myData = vector;
            //double ourRecAccuracy = nn.Accuracy(ourData);
            // int[] iz = nn.GetMyResponses(ourData);
            int ab = nn.GetMySingleResponses(myData);

            Console.WriteLine("\nOur Data");
            // Console.WriteLine(string.Join(",", iz));
            Console.WriteLine("\nRange is  " + ab * 2 + " to " + (ab + 1) * 2);
            // Console.WriteLine(ourRecAccuracy.ToString("F4"));
            //End

            return ab;
        }
        //End

        //start
        public static int[] getManyRating(double[][] vector) //
        {

            //Start
            Console.WriteLine("Creating a 4-6-3 neural network");
            Console.WriteLine("Using tanh and softmax activations");
            const int numInput = 46;
            const int numHidden = 3;
            const int numOutput = 5;
            ann nn =
            new ann(numInput, numHidden, numOutput);

            // training parameters specific to EO
            int popSize = 25;
            int maxGeneration = 5500;
            double exitError = 0.0;
            double mutateRate = 0.09999999;
            double mutateChange = 5.905; //0.005
            double tau = 0.40;

            // int popSize = 25;
            //  int maxGeneration = 5500;
            //  double exitError = 0.0;
            //  double mutateRate = 0.09999999;
            //  double mutateChange = 5.905; //0.005
            //   double tau = 0.40;

            Console.WriteLine("\nSetting popSize = " + popSize);
            Console.WriteLine("Setting maxGeneration = " + maxGeneration);
            Console.Write("Setting early exit MSE error = ");
            Console.WriteLine(exitError.ToString("F3"));
            Console.Write("Setting mutateRate = ");
            Console.WriteLine(mutateRate.ToString("F3"));
            Console.Write("Setting mutateChange = ");
            Console.WriteLine(mutateChange.ToString("F3"));
            Console.Write("Setting tau = ");
            Console.WriteLine(tau.ToString("F3"));

            double[][] allData = LoadData("C:\\Users\\infer\\Desktop\\Fall16\\BigData\\Project\\finalData\\input.csv", 10181, 51); // 150 rows, 7 cols
        
            Console.WriteLine("Aim is to predict the range of IMBD Rating For an movie");
            Console.WriteLine("Factors Considered Actors, Directors, Writers, IMDB Votes, FB Fan Count, FB Fan Votes, Twitter Votes, Year Of Release, Genre, Type (Movie, Episode, Series)");
            Console.WriteLine("Ratings in range of 0-2 / Out 0, 2-4 / Out 1, 4-6 / Out 2, 6-8 / Out 3, 8-10 / Out 4");
            Console.WriteLine("\nThe 150-item data set is:\n");
            // ShowMatrix(allData, 4, 1, true);

            double[][] trainData = null;
            double[][] testData = null;
            double trainPct = 0.70;
            int splitSeed = 1;
            Console.WriteLine("Splitting data into 70% train, 30% test");
            SplitData(allData, trainPct, splitSeed, out trainData, out testData);
            //   Console.WriteLine("\nThe training data is:\n");
            //  ShowMatrix(trainData, 4, 1, true);
            //  Console.WriteLine("The test data is:\n");
            //  ShowMatrix(testData, 3, 1, true);

            Console.WriteLine("\nBeginning training");
            double[] bestWeights = nn.Train(trainData, popSize, maxGeneration, exitError,
            mutateRate, mutateChange, tau);
            Console.WriteLine("Training complete");
            Console.WriteLine("\nFinal weights and bias values:");
            ShowVector(bestWeights, 10, 3, true);





            nn.SetWeights(bestWeights);
            double trainAcc = nn.Accuracy(trainData);
            Console.Write("\nAccuracy on training data = ");
            Console.WriteLine(trainAcc.ToString("F4"));

            double testAcc = nn.Accuracy(testData);
            Console.Write("\nAccuracy on test data = ");
            Console.WriteLine(testAcc.ToString("F4"));


            Console.WriteLine("\nTESTING Our OWN Data");
            //need to implement for soecific Film
            double[][] ourData = vector;
            //double[] myData = vector;
            double ourRecAccuracy = nn.Accuracy(ourData);
            int[] iz = nn.GetMyResponses(ourData);

            //Console.WriteLine("\nOur Data");
            //Console.WriteLine(string.Join(",", iz));
            //  Console.WriteLine("\nRange is  " + ab * 2 + " to " + (ab + 1) * 2);
            //Console.WriteLine(ourRecAccuracy.ToString("F4"));
            //End

            return iz;
        }
        //End
        //end

        static void Main(string[] args)
        {

            //double[] myData = new double[51] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0, 1.0, 0.0, 0.0, 7.7666664, 7.3, 7.31, 5.0, 4.0, 5.0, 0.0, 0.0, 0.0, 1.0, 0.0 };
            //Console.WriteLine("\nReturned value is " + z);
            //int z = getRating(myData);

            double[][] ourData = LoadData("C:\\Users\\infer\\Desktop\\Fall16\\BigData\\Project\\finalData\\inputMini.csv", 1, 51);
            int[] r = getManyRating(ourData);

            Console.WriteLine("\nThe prediction for this movie is---->");
            if (r[0] == 0)
            {
                Console.WriteLine("Flop!");
            }
            else if (r[0] == 1)
            {
                Console.WriteLine("Okay-ish!");
            }
            else if (r[0] == 2)
            {
                Console.WriteLine("Average!");
            }
            else if (r[0] == 3)
            {
                Console.WriteLine("Pretty Good!");
            }
            else if (r[0] == 4)
            {
                Console.WriteLine("Box Office Hit!");
            }
            Console.WriteLine(string.Join(",", r));


            Console.ReadLine();


        }
        //Start
        private static int MaxIndex(double[] vector)
        {
            int bigIndex = 0;
            double biggestVal = vector[0];
            for (int i = 0; i < vector.Length; ++i)
            {
                if (vector[i] > biggestVal)
                {
                    biggestVal = vector[i]; bigIndex = i;
                }
            }
            return bigIndex;
        }
        //End
        static double[][] LoadData(string dataFile, int numRows, int numCols)
        {
            double[][] result = new double[numRows][];
            FileStream ifs = new FileStream(dataFile, FileMode.Open);
            StreamReader sr = new StreamReader(ifs);
            string line = "";
            string[] tokens = null;
            int i = 0;
            while ((line = sr.ReadLine()) != null)
            {
                if (line[0] != '/' && line[1] != '/') //allows for comments
                {
                    tokens = line.Split(',');
                    result[i] = new double[numCols];
                    for (int j = 0; j < numCols; ++j)
                    {
                        result[i][j] = double.Parse(tokens[j]);
                    }
                    ++i;
                }
            }
            sr.Dispose();
            ifs.Dispose();
            return result;
        }

        static void SplitData(double[][] allData, double trainPct,
    int seed, out double[][] trainData, out double[][] testData)
        {
            Random rnd = new Random(seed);
            int totRows = allData.Length;
            int numTrainRows = (int)(totRows * trainPct); // usually 0.80
            int numTestRows = totRows - numTrainRows;
            trainData = new double[numTrainRows][];
            testData = new double[numTestRows][];

            double[][] copy = new double[allData.Length][]; // ref copy of data
            for (int i = 0; i < copy.Length; ++i)
                copy[i] = allData[i];

            for (int i = 0; i < copy.Length; ++i) // scramble order of copy
            {
                int r = rnd.Next(i, copy.Length); // use Fisher-Yates
                double[] tmp = copy[r];
                copy[r] = copy[i];
                copy[i] = tmp;
            }
            for (int i = 0; i < numTrainRows; ++i) // by ref
                trainData[i] = copy[i];

            for (int i = 0; i < numTestRows; ++i)
                testData[i] = copy[i + numTrainRows];
        } // SplitData


        public static void ShowMatrix(double[][] matrix, int numRows,
    int decimals, bool indices)
        {
            int len = matrix.Length.ToString().Length;
            for (int i = 0; i < numRows; ++i)
            {
                if (indices == true)
                    Console.Write("[" + i.ToString().PadLeft(len) + "]  ");
                for (int j = 0; j < matrix[i].Length; ++j)
                {
                    double v = matrix[i][j];
                    if (v >= 0.0)
                        Console.Write(" "); // '+'
                    Console.Write(v.ToString("F" + decimals) + "  ");
                }
                Console.WriteLine("");
            }

            if (numRows < matrix.Length)
            {
                Console.WriteLine(". . .");
                int lastRow = matrix.Length - 1;
                if (indices == true)
                    Console.Write("[" + lastRow.ToString().PadLeft(len) + "]  ");
                for (int j = 0; j < matrix[lastRow].Length; ++j)
                {
                    double v = matrix[lastRow][j];
                    if (v >= 0.0)
                        Console.Write(" "); // '+'
                    Console.Write(v.ToString("F" + decimals) + "  ");
                }
            }
            Console.WriteLine("\n");
        }

        public static void ShowVector(double[] vector, int decimals,
            int lineLen, bool newLine)
        {
            for (int i = 0; i < vector.Length; ++i)
            {
                if (i > 0 && i % lineLen == 0) Console.WriteLine("");
                if (vector[i] >= 0) Console.Write(" ");
                Console.Write(vector[i].ToString("F" + decimals) + " ");
            }
            if (newLine == true)
                Console.WriteLine("");
        }
    }

    public class Individual : IComparable<Individual>
    {
        public double[] chromosome; // represents a solution
        public double error; // smaller values are better for minimization

        private int numGenes; // problem dimension (numWeights)
        private double minGene; // smallest value for a chromosome cell
        private double maxGene;
        private double mutateRate; // used during reproduction by Mutate
        private double mutateChange; // used during reproduction

        static Random rnd = new Random(0); // used by ctor for random genes

        public Individual(int numGenes, double minGene, double maxGene,
            double mutateRate, double mutateChange)
        {
            this.numGenes = numGenes;
            this.minGene = minGene;
            this.maxGene = maxGene;
            this.mutateRate = mutateRate;
            this.mutateChange = mutateChange;
            this.chromosome = new double[numGenes];
            for (int i = 0; i < this.chromosome.Length; ++i)
                this.chromosome[i] = (maxGene - minGene) * rnd.NextDouble() + minGene;
            // this.error supplied after calling ctor!
        }

        public int CompareTo(Individual other) // smallest error to largest
        {
            if (this.error < other.error) return -1;
            else if (this.error > other.error) return 1;
            else return 0;
        }
    } // class Individual


    public class ann
    {
        private int numInput;
        private int numHidden;
        private int numOutput;
        private double[] inputs;
        private double[][] ihWeights;
        private double[] hBiases;
        private double[] hOutputs;
        private double[][] hoWeights;
        private double[] oBiases;
        private double[] outputs;

        private Random rnd;

        public ann(int numInput, int numHidden, int numOutput)
        {
            this.numInput = numInput;
            this.numHidden = numHidden;
            this.numOutput = numOutput;
            this.inputs = new double[numInput];
            this.ihWeights = MakeMatrix(numInput, numHidden);
            this.hBiases = new double[numHidden];
            this.hOutputs = new double[numHidden];
            this.hoWeights = MakeMatrix(numHidden, numOutput);
            this.oBiases = new double[numOutput];
            this.outputs = new double[numOutput];
            rnd = new Random(0);
        }

        private static double[][] MakeMatrix(int rows, int cols)
        {
            // helper for NN ctor
            double[][] result = new double[rows][];
            for (int r = 0; r < result.Length; ++r)
                result[r] = new double[cols];
            return result;
        }

        public void SetWeights(double[] weights)
        {
            // sets weights and biases from weights[]
            int numWeights = (numInput * numHidden) +
                (numHidden * numOutput) + numHidden + numOutput;
            if (weights.Length != numWeights)
                throw new Exception("Bad weights array length: ");

            int k = 0; // points into weights param

            for (int i = 0; i < numInput; ++i)
                for (int j = 0; j < numHidden; ++j)
                    ihWeights[i][j] = weights[k++];
            for (int i = 0; i < numHidden; ++i)
                hBiases[i] = weights[k++];
            for (int i = 0; i < numHidden; ++i)
                for (int j = 0; j < numOutput; ++j)
                    hoWeights[i][j] = weights[k++];
            for (int i = 0; i < numOutput; ++i)
                oBiases[i] = weights[k++];
        }

        public double[] GetWeights()
        {
            // returns current weights and biases
            int numWeights = (numInput * numHidden) +
                (numHidden * numOutput) + numHidden + numOutput;
            double[] result = new double[numWeights];
            int k = 0;
            for (int i = 0; i < ihWeights.Length; ++i)
                for (int j = 0; j < ihWeights[0].Length; ++j)
                    result[k++] = ihWeights[i][j];
            for (int i = 0; i < hBiases.Length; ++i)
                result[k++] = hBiases[i];
            for (int i = 0; i < hoWeights.Length; ++i)
                for (int j = 0; j < hoWeights[0].Length; ++j)
                    result[k++] = hoWeights[i][j];
            for (int i = 0; i < oBiases.Length; ++i)
                result[k++] = oBiases[i];
            return result;
        }

        public double[] ComputeYs(double[] xValues)
        {
            // feed-forward mechanism for NN classifier
            if (xValues.Length != numInput)
                throw new Exception("Bad xValues array length");

            double[] hSums = new double[numHidden];
            double[] oSums = new double[numOutput];

            for (int i = 0; i < xValues.Length; ++i)
                this.inputs[i] = xValues[i];

            for (int j = 0; j < numHidden; ++j)
                for (int i = 0; i < numInput; ++i)
                    hSums[j] += this.inputs[i] * this.ihWeights[i][j];

            for (int i = 0; i < numHidden; ++i)
                hSums[i] += this.hBiases[i];

            for (int i = 0; i < numHidden; ++i)
                this.hOutputs[i] = HyperTanFunction(hSums[i]);

            for (int j = 0; j < numOutput; ++j)
                for (int i = 0; i < numHidden; ++i)
                    oSums[j] += hOutputs[i] * hoWeights[i][j];

            for (int i = 0; i < numOutput; ++i)
                oSums[i] += oBiases[i];

            double[] softOut = Softmax(oSums);
            Array.Copy(softOut, outputs, softOut.Length);

            double[] retResult = new double[numOutput];
            Array.Copy(this.outputs, retResult, retResult.Length);
            return retResult;
        }

        private static double HyperTanFunction(double x)
        {
            if (x < -20.0) return -1.0;
            else if (x > 20.0) return 1.0;
            else return Math.Tanh(x);
        }

        private static double[] Softmax(double[] oSums)
        {
            double max = oSums[0];
            for (int i = 0; i < oSums.Length; ++i)
                if (oSums[i] > max) max = oSums[i];

            // determine scaling factor
            double scale = 0.0;
            for (int i = 0; i < oSums.Length; ++i)
                scale += Math.Exp(oSums[i] - max);

            double[] result = new double[oSums.Length];
            for (int i = 0; i < oSums.Length; ++i)
                result[i] = Math.Exp(oSums[i] - max) / scale;

            return result; // scaled so xi sum to 1.0
        }

        public double[] Train(double[][] trainData,
    int popSize, int maxGeneration, double exitError,
    double mutateRate, double mutateChange, double tau)
        {
            // use Evolutionary Optimization to train NN

            int numWeights = (this.numInput * this.numHidden) +
            (this.numHidden * this.numOutput) +
            this.numHidden + this.numOutput; // = numGenes

            double minX = -10.0; // could be parameters. = minGene
            double maxX = 10.0;

            // initialize population
            Individual[] population = new Individual[popSize];
            double[] bestSolution = new double[numWeights]; // best solution any individual
            double bestError = double.MaxValue; // smaller values better

            for (int i = 0; i < population.Length; ++i)
            {
                population[i] = new Individual(numWeights, minX, maxX, mutateRate,
                    mutateChange); // random values
                double error = MeanSquaredError(trainData, population[i].chromosome);
                population[i].error = error;
                if (population[i].error < bestError)
                {
                    bestError = population[i].error;
                    Array.Copy(population[i].chromosome, bestSolution, numWeights);
                }
            }

            // main EO processing loop
            int gen = 0; bool done = false;
            while (gen < maxGeneration && done == false)
            {
                Individual[] parents = Select(2, population, tau); // 2 good Individuals
                Individual[] children = Reproduce(parents[0], parents[1], minX, maxX,
                    mutateRate, mutateChange); // create 2 children
                children[0].error = MeanSquaredError(trainData, children[0].chromosome);
                children[1].error = MeanSquaredError(trainData, children[1].chromosome);

                Place(children[0], children[1], population); // sort pop, replace two worst 

                // immigration
                // kill off third-worst Individual and replace with new Individual
                // assumes population is sorted (via Place()
                Individual immigrant = new Individual(numWeights, minX, maxX, mutateRate, mutateChange);
                immigrant.error = MeanSquaredError(trainData, immigrant.chromosome);
                population[population.Length - 3] = immigrant; // replace third worst individual

                for (int i = popSize - 3; i < popSize; ++i) // check the 3 new Individuals
                {
                    if (population[i].error < bestError)
                    {
                        bestError = population[i].error;
                        population[i].chromosome.CopyTo(bestSolution, 0);
                        if (bestError < exitError)
                        {
                            done = true;
                            Console.WriteLine("\nEarly exit at generation " + gen);
                        }
                    }
                }
                ++gen;
            }
            return bestSolution;
        } // Train

        private double MeanSquaredError(double[][] trainData,
    double[] weights)
        {
            // how far off are computed values from desired values
            this.SetWeights(weights);

            double[] xValues = new double[numInput]; // inputs
            double[] tValues = new double[numOutput]; // targets
            double sumSquaredError = 0.0;
            for (int i = 0; i < trainData.Length; ++i)
            {
                // assumes data has x-values followed by y-values
                Array.Copy(trainData[i], xValues, numInput);
                Array.Copy(trainData[i], numInput, tValues, 0,
                    numOutput);
                double[] yValues = this.ComputeYs(xValues);
                for (int j = 0; j < yValues.Length; ++j)
                    sumSquaredError += ((yValues[j] - tValues[j]) *
                                        (yValues[j] - tValues[j]));
            }
            return sumSquaredError / trainData.Length;
        }

        public double Accuracy(double[][] testData)
        {
            // percentage correct using 'winner-takes all'
            int numCorrect = 0;
            int numWrong = 0;
            double[] xValues = new double[numInput]; // inputs
            double[] tValues = new double[numOutput]; // targets
            double[] yValues; // computed outputs

            for (int i = 0; i < testData.Length; ++i)
            {
                Array.Copy(testData[i], xValues, numInput);
                Array.Copy(testData[i], numInput, tValues, 0,
                    numOutput);
                yValues = this.ComputeYs(xValues);

                int maxIndex = MaxIndex(yValues);

                if (tValues[maxIndex] == 1.0) // not so nice
                    ++numCorrect;
                else
                    ++numWrong;
            }
            return (numCorrect * 1.0) / (numCorrect + numWrong);
        }

        // To get Responses for my passed movies
        public int[] GetMyResponses(double[][] testData)
        {
            // percentage correct using 'winner-takes all'
            int numCorrect = 0;
            int numWrong = 0;
            int[] returnedValues = new int[testData.Length];
            double[] xValues = new double[numInput]; // inputs
            double[] tValues = new double[numOutput]; // targets
            double[] yValues; // computed outputs

            for (int i = 0; i < testData.Length; ++i)
            {
                Array.Copy(testData[i], xValues, numInput);
                Array.Copy(testData[i], numInput, tValues, 0,
                    numOutput);
                yValues = this.ComputeYs(xValues);

                int maxIndex = MaxIndex(yValues);

                returnedValues[i] = maxIndex;


            }
            return returnedValues;
        }
        //

        // To get Responses for my passed movies
        public int GetMySingleResponses(double[] input)
        {
            // percentage correct using 'winner-takes all'
            double[] xValues = new double[numInput]; // inputs
            double[] tValues = new double[numOutput]; // targets
            double[] yValues; // computed outputs


            Array.Copy(input, xValues, numInput);
            Array.Copy(input, numInput, tValues, 0,
                numOutput);
            yValues = this.ComputeYs(xValues);

            return MaxIndex(yValues);
        }
        //

        private static int MaxIndex(double[] vector)
        {
            int bigIndex = 0;
            double biggestVal = vector[0];
            for (int i = 0; i < vector.Length; ++i)
            {
                if (vector[i] > biggestVal)
                {
                    biggestVal = vector[i]; bigIndex = i;
                }
            }
            return bigIndex;
        }

        private Individual[] Select(int n, Individual[] population, double tau)
        {
            // tau is selection pressure = % of population to grab
            int popSize = population.Length;
            int[] indexes = new int[popSize];
            for (int i = 0; i < indexes.Length; ++i)
                indexes[i] = i;

            for (int i = 0; i < indexes.Length; ++i) // shuffle
            {
                int r = rnd.Next(i, indexes.Length);
                int tmp = indexes[r]; indexes[r] = indexes[i]; indexes[i] = tmp;
            }

            int tournSize = (int)(tau * popSize);
            if (tournSize < n) tournSize = n;
            Individual[] candidates = new Individual[tournSize];

            for (int i = 0; i < tournSize; ++i)
                candidates[i] = population[indexes[i]];
            Array.Sort(candidates);

            Individual[] results = new Individual[n];
            for (int i = 0; i < n; ++i)
                results[i] = candidates[i];

            return results;
        }

        private Individual[] Reproduce(Individual parent1, Individual parent2,
    double minGene, double maxGene, double mutateRate, double mutateChange)
        {
            int numGenes = parent1.chromosome.Length;
            int cross = rnd.Next(0, numGenes - 1); // crossover point. 0 means 'between 0 and 1'.

            Individual child1 = new Individual(numGenes, minGene, maxGene,
            mutateRate, mutateChange); // random chromosome
            Individual child2 = new Individual(numGenes, minGene, maxGene,
            mutateRate, mutateChange);

            for (int i = 0; i <= cross; ++i)
                child1.chromosome[i] = parent1.chromosome[i];
            for (int i = cross + 1; i < numGenes; ++i)
                child2.chromosome[i] = parent1.chromosome[i];
            for (int i = 0; i <= cross; ++i)
                child2.chromosome[i] = parent2.chromosome[i];
            for (int i = cross + 1; i < numGenes; ++i)
                child1.chromosome[i] = parent2.chromosome[i];

            Mutate(child1, maxGene, mutateRate, mutateChange);
            Mutate(child2, maxGene, mutateRate, mutateChange);

            Individual[] result = new Individual[2];
            result[0] = child1;
            result[1] = child2;

            return result;
        } // Reproduce

        private static void Place(Individual child1, Individual child2,
    Individual[] population)
        {
            // place child1 and child2 replacing two worst individuals
            int popSize = population.Length;
            Array.Sort(population);
            population[popSize - 1] = child1;
            population[popSize - 2] = child2;
            return;
        }

        private void Mutate(Individual child, double maxGene, double mutateRate,
    double mutateChange)
        {
            double hi = mutateChange * maxGene;
            double lo = -hi;
            for (int i = 0; i < child.chromosome.Length; ++i)
            {
                if (rnd.NextDouble() < mutateRate)
                {
                    double delta = (hi - lo) * rnd.NextDouble() + lo;
                    child.chromosome[i] += delta;
                }
            }
        }

    }
}
