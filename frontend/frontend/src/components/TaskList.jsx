import { useEffect, useState } from "react";
import { getTasks } from "../services/TaskService";

function TaskList() {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    const data = await getTasks();
    setTasks(data);
  };

  return (
    <div>
      <h2>Liste des tâches</h2>

      {tasks.map((task) => (
        <div key={task.id}>
          <h3>{task.title}</h3>
          <p>{task.description}</p>
          <p>{task.completed ? "Terminée" : "En cours"}</p>
        </div>
      ))}
    </div>
  );
}

export default TaskList;