export interface TaskResponseArgs {
  id: number;
  content: string;
  urgency: number;
  importance: number;
  done: boolean;
}

class TaskResponse {
  id: number;
  content: string;
  urgency: number;
  importance: number;
  done: boolean;

  constructor(args: TaskResponseArgs) {
    this.id = args.id;
    this.content = args.content;
    this.urgency = args.urgency;
    this.importance = args.importance;
    this.done = args.done;
  }
}

export default TaskResponse;
