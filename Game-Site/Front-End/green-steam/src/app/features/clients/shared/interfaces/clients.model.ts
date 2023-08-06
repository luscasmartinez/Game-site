import { Client } from "./client.model";

export interface Clients {
  items: Array<Client>;
  hasNext: boolean;
  remainingRecords: number;
}
