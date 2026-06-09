import {
  PieChart,
  Pie,
  Cell,
  Tooltip,
  Legend
} from "recharts";

function DashboardChart({ summary }) {

  const data = [
    {
      name: "Applied",
      value: summary.Applied
    },
    {
      name: "Interview Scheduled",
      value: summary["Interview Scheduled"]
    },
    {
      name: "Selected",
      value: summary.Selected
    },
    {
      name: "Rejected",
      value: summary.Rejected
    }
  ];

  const COLORS = [
    "#2563eb",
    "#f59e0b",
    "#16a34a",
    "#dc3545"
  ];

  return (

    <PieChart
      width={500}
      height={300}
    >

      <Pie
        data={data}
        cx="50%"
        cy="50%"
        outerRadius={100}
        fill="#8884d8"
        dataKey="value"
        label
      >

        {data.map((entry, index) => (

          <Cell
            key={`cell-${index}`}
            fill={
              COLORS[
                index % COLORS.length
              ]
            }
          />

        ))}

      </Pie>

      <Tooltip />

      <Legend />

    </PieChart>

  );

}

export default DashboardChart;