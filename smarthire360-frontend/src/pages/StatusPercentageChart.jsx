import {
  PieChart,
  Pie,
  Tooltip
} from "recharts";

function StatusPercentageChart({ data }) {

  const chartData =
    Object.keys(data || {}).map((key) => ({
      name: key,
      value: data[key]
    }));

  return (

    <PieChart width={400} height={300}>

      <Pie
        data={chartData}
        dataKey="value"
        outerRadius={100}
        label
      />

      <Tooltip />

    </PieChart>

  );

}

export default StatusPercentageChart;