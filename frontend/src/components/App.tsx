import React from 'react';
import '../App.css';
import TaskResponse, { TaskResponseArgs } from '../domain/TaskResponse';
import ApiClient from '../utils/ApiClient';
import _ from 'lodash'; 
import Task from './Task';

interface Props {}
interface State {
  tasks: TaskResponse[];
}

class App extends React.Component<Props, State> {
  constructor(props: Props) {
    super(props);
    this.state = {
      tasks: []
    }
  }

  componentDidMount() {
    ApiClient.get<TaskResponseArgs[]>('/tasks')
      .then(tasks => {
        this.setState({
          tasks: _.map(tasks, t => new TaskResponse(t))
        });
      });
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <p>Spring Boot Todo</p>
        </header>
        <body>
          <table>
            <tr>
              <th>チェック</th>
              <th>内容</th>
              <th>緊急度</th>
              <th>重要度</th>
            </tr>
            {this.state.tasks.map(task => {
              return <Task 
                id={task.id}
                content={task.content}
                urgency={task.urgency}
                importance={task.importance}
                done={task.done}
              />
            })}
          </table>
        </body>
      </div>
    );
  }
}

export default App;
