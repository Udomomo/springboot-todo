export interface TaskRequestArgs {
  content: string;
  urgency: number;
  importance: number;
}

class TaskRequest {
  content: string;
  urgency: number;
  importance: number;

  constructor(args: TaskRequestArgs) {
    this.content = args.content;
    this.urgency = args.urgency;
    this.importance = args.importance;
  }
}

export default TaskRequest;
